function addIssue(){
    let codeIssue = document.getElementById("codeIssue").value;
    if (codeIssue == "UGCwdFJW"){
        newIssue();
        $("#closeIssue").trigger('click');
        document.getElementById("codeIssue").value = "";
    } else {
        alert("Wrong code");
    }
}


function newIssue(){
    index ++;

    let addedProblem = document.getElementById("addedProblem").innerHTML;

    let tlOption = document.getElementById("tl").innerHTML;
    let open = "<div class='col-auto'><div class='input-group mb-2'>";
    let close = "</div><hr></div>"

    let select = "<select class='form-control tlClass' id='reparations" + index + ".tl' name='reparations[" + index + "].tl'>";
    let divOption = "<div class='input-group-prepend'><div class='tl'> " + tlOption + "</div></div>";

    let inputImei = "<input id='reparations" + index + ".imei' name='reparations[" + index + "].imei' value='" + imei + "' type='hidden'>";
    let inputOperator = "<input id='reparations" + index + ".operator' name='reparations[" + index + "].operator' value='" + operator + "' type='hidden'>";

    let componentSku = document.getElementById("componentSku").innerHTML;

    let imgUrl = document.getElementById("repair0").url;

    let componentOption = "<select onchange='report("+ index +")' style='max-width:280px' id='select" + index +"' class='form-control selection" + index + "' name='reparations[" + index +"].component' required='true'><option id='notNeed" + index +"' value=''>" + componentSku + "<select><img id='repair" + index + "' src='" + imgUrl + "' style='height:30px; padding-left:10px; padding-top: 10px'onClick='notNeed(" + index + ")'>";

    $('#addedProblem').append(open + inputImei + inputOperator + select + divOption + "</select>" + componentOption + close);



    $(".selection" + index).select2();
}


