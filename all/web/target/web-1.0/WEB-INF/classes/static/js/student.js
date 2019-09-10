function() {
    var regNo = $('#inputRegNo').val();
    var year = $("input[name='year-radios']:checked").val();

    if (year === 1) {

        //Hide all element related to Year II
    }
    var al = parseInt($("#checkboxAL:checked").val());
    var dip = parseInt($("#checkboxDip:checked").val());
    if(!$('#checkboxAL').is(':checked')){
        al =0;
    }

    if(!$('#checkboxDip').is(':checked')){
        dip =0;
    }
    var priorKnowledge = al + dip;
    if(priorKnowledge === 4){
        priorKnowledge = 5;
    }

    var hourYearI = $("input[name='radio-hoursI']:checked").val();
    var hourYearII = $("input[name='radio-hoursII']:checked").val();
    var gpaI = $("#inputGpaI").val();
    var gpaII = $("#inputGpaII").val();
    var devProjects = $("#inputProjects").val();
    $("#input-select").change(function(){

        var interactLecturer = $(this).children("option:selected").val();

    });
    console.log('Reg No ' + regNo + ' year ' + year + ' prior knowledge ' + priorKnowledge + ' hours I ' + hourYearI + ' hours II ' + ' GPA I ' + gpaI + ' GPA II ' + gpaII +
    ' developed project ' + devProjects + ' interaction ' + interactLecturer);
    $.ajax({
        type: "POST",
        url:"save",
        async: false,
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify({
            "registrationNumber" : regNo,
            "priorKnowledge" : priorKnowledge,
            "hoursOfWeeklyStudyI" : hourYearI,
            "hoursOfWeeklyStudyII" : hourYearII,
            "interactionWithLecturer" : interactLecturer,
            "GPAYearI" : gpaI,
            "GPAYearII" : gpaII,
            "developedProjects" : devProjects
        }),
        error: function(response){
            console.log("Error occurred: " + response.responseText);
        }, success: function () {
            //console.log("Error occurred: " + response.responseText);
            alert('success');
        }
    });
    // alert('Reg No ' + regNo + ' year ' + year + ' prior knowledge ' + priorKnowledge + ' hours I ' + hourYearI + ' hours II ' + ' GPA I ' + gpaI + ' GPA II ' + gpaII +
    //     ' developed project ' + devProjects + ' interaction ' + interactLecturer);
}

function show() {
    $.ajax({
        type: "GET",
        url: "/show",
        contentType: "application/json; charset=utf-8",
        async: false,
        success: function(data){
            document.getElementById("gpaI").innerHTML = data.GPAYearI;
        },
        error: function (response) {
            console.log("Error occurred: " + response.responseText)
        }
    })
}
