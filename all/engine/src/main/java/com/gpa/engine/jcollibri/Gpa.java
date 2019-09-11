package com.gpa.engine.jcollibri;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

import com.gpa.engine.dto.StudentDTO;
import com.opencsv.CSVWriter;
import es.ucm.fdi.gaia.jcolibri.casebase.LinealCaseBase;
import es.ucm.fdi.gaia.jcolibri.cbraplications.StandardCBRApplication;
import es.ucm.fdi.gaia.jcolibri.cbrcore.Attribute;
import es.ucm.fdi.gaia.jcolibri.cbrcore.CBRCase;
import es.ucm.fdi.gaia.jcolibri.cbrcore.CBRCaseBase;
import es.ucm.fdi.gaia.jcolibri.cbrcore.CBRQuery;
import es.ucm.fdi.gaia.jcolibri.cbrcore.Connector;
import es.ucm.fdi.gaia.jcolibri.connector.PlainTextConnector;
import es.ucm.fdi.gaia.jcolibri.datatypes.Instance;
import es.ucm.fdi.gaia.jcolibri.exception.ExecutionException;
import es.ucm.fdi.gaia.jcolibri.method.retrieve.NNretrieval.similarity.local.ontology.OntCosine;
import es.ucm.fdi.gaia.jcolibri.method.retrieve.RetrievalResult;
import es.ucm.fdi.gaia.jcolibri.method.retrieve.NNretrieval.NNConfig;
import es.ucm.fdi.gaia.jcolibri.method.retrieve.NNretrieval.NNScoringMethod;
import es.ucm.fdi.gaia.jcolibri.method.retrieve.NNretrieval.similarity.global.Average;
import es.ucm.fdi.gaia.jcolibri.method.retrieve.NNretrieval.similarity.local.Equal;
import es.ucm.fdi.gaia.jcolibri.method.retrieve.selection.SelectCases;
import es.ucm.fdi.gaia.jcolibri.util.FileIO;
import es.ucm.fdi.gaia.ontobridge.OntoBridge;
import es.ucm.fdi.gaia.ontobridge.OntologyDocument;


public class Gpa implements StandardCBRApplication
{
	private static final String OUT_CSV_FILE_PATH = "F:/GITHUB/UnivoProject/all/engine/src/main/resources/out.csv";

    /** Connector object */
    Connector _connector;
    /** CaseBase object */
    CBRCaseBase _caseBase;

    /** KNN config */
    NNConfig simConfig;

    public void configure() throws ExecutionException
    {
	// Create a data base connector
	_connector = new PlainTextConnector();
	// Init the ddbb connector with the config file
	_connector.initFromXMLfile(es.ucm.fdi.gaia.jcolibri.util.FileIO
			.findFile("F:/GITHUB/UnivoProject/all/engine/src/main/resources/jcollibriconfig.xml"));
	// Create a Lineal case base for in-memory organization
	_caseBase = new LinealCaseBase();

		// Obtain a reference to OntoBridge
		OntoBridge ob = es.ucm.fdi.gaia.jcolibri.util.OntoBridgeSingleton.getOntoBridge();
		// Configure it to work with the Pellet reasoner
		ob.initWithPelletReasoner();
		// Setup the main ontology
		OntologyDocument mainOnto = new OntologyDocument("http://gaia.fdi.ucm.es/ontologies/gpa.owl",
				FileIO.findFile("F:/GITHUB/UnivoProject/all/engine/src/main/resources/gpa.owl").toExternalForm());
		// There are not subontologies
		ArrayList<OntologyDocument> subOntologies = new ArrayList<OntologyDocument>();
		// Load the ontology
		ob.loadOntology(mainOnto, subOntologies, false);
	
	simConfig = new NNConfig();
	// Set the average() global similarity function for the description of the case
	simConfig.setDescriptionSimFunction(new Average());
	simConfig.addMapping(new Attribute("priorKnowledge", GpaDescription.class), new Equal());
	simConfig.addMapping(new Attribute("hoursOfWeeklyStudyI", GpaDescription.class), new Equal());
	simConfig.addMapping(new Attribute("hoursOfWeeklyStudyII", GpaDescription.class), new Equal());
	simConfig.addMapping(new Attribute("interactionWithLecturer", GpaDescription.class), new Equal());
	simConfig.addMapping(new Attribute("developedProjects", GpaDescription.class), new Equal());
	simConfig.addMapping(new Attribute("gpaYearI", GpaDescription.class), new Equal());
	simConfig.addMapping(new Attribute("gpaYearII", GpaDescription.class), new Equal());
	simConfig.addMapping(new Attribute("preferredArea", GpaDescription.class), new OntCosine());


	}

    public void cycle(CBRQuery query) throws ExecutionException {

		// Execute KNN
		Collection<RetrievalResult> eval = NNScoringMethod.evaluateSimilarity(_caseBase.getCases(), query, simConfig);

		// Select cases
		Collection<CBRCase> retrievedCases = SelectCases.selectTopK(eval, 1);

		// Print the retrieval
		for (CBRCase nse : retrievedCases) {
			GpaDescription gpaDescription =  (GpaDescription) nse.getDescription();
			System.out.println("GPA : " + gpaDescription.getFinalGpa());

			//update final gpa to the db or csv file
            CSVWriter csvWriter = null;
            try {
                csvWriter = new CSVWriter(new FileWriter(OUT_CSV_FILE_PATH));
            } catch (IOException e) {
                e.printStackTrace();
            }

			String gpa = gpaDescription.getFinalGpa().toString();
            String[] records = {gpa};
            csvWriter.writeNext(records);
            try {
                csvWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

	}

   public void postCycle() throws ExecutionException
    {
	_connector.close();
    }

    public CBRCaseBase preCycle() throws ExecutionException
    {
	// Load cases from connector into the case base
	_caseBase.init(_connector);		
	// Print the cases
	Collection<CBRCase> cases = _caseBase.getCases();
	for(CBRCase c: cases)
		System.out.println(c);
	return _caseBase;
    }
    

    public static void main(String[] args) {

		StudentDTO studentDTO =new StudentDTO();

		StandardCBRApplication recommender = new Gpa();
	try
	{
	    recommender.configure();

	    recommender.preCycle();

	    CBRQuery query = new CBRQuery();

		GpaDescription hd = new GpaDescription();
		hd.setId(studentDTO.getRegistrationNumber());
		hd.setHoursOfWeeklyStudyI(studentDTO.getHoursOfWeeklyStudyI());
		hd.setHoursOfWeeklyStudyII(studentDTO.getHoursOfWeeklyStudyII());
		hd.setPriorKnowledge(studentDTO.getPriorKnowledge());
		hd.setDevelopedProjects(studentDTO.getDevelopedProjects());
		hd.setGpaYearI(studentDTO.getGpaYearI());
		hd.setGpaYearII(studentDTO.getGpaYearII());
		hd.setInteractionWithLecturer(studentDTO.getInteractionWithLecturer());
		hd.setPreferredArea(new Instance(studentDTO.getPreferredArea()));
		query.setDescription(hd);

	    recommender.cycle(query);

	    recommender.postCycle();

	} catch (Exception e)
	{
	    //org.apache.commons.logging.LogFactory.getLog(Gpa.class).error(e);
	    e.printStackTrace();

	}

    }

}
