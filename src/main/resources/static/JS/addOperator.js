let i = -1;
let maxQty;
let assignedQty = 0;

function insertValue(){
    let qty = document.getElementsByClassName("qty")
    let tempQty = 0;

    for (let q = 0; q < qty.length; q ++){
        tempQty = Number(tempQty) + Number(qty[q].value);
    }

    assignedQty = Number(tempQty);

    if (assignedQty > maxQty){
        document.getElementById("tooQty").style.display = "block";
    } else {
        document.getElementById("tooQty").style.display = "none";
    }

}

function rem(n) {
    let id = "tb" + n;
    $("#" + id).remove();

    i = i - 1;

    if (i < 0) {
        document.getElementById("remove").style.display = "none";
    }

    document.getElementById("remove").innerHTML = "<button class='btn btn-outline-danger' id='btnRemove' onClick='rem(" + i + ")' type='button'>remove</button>";
}

function add() {
    i++

    maxQty = Number(document.getElementById("qtyToAssign").innerHTML);

    document.getElementById("remove").style.display = 'block';

    let openTable = "<table id='tb" + i + "' style='margin-right: 10px; border-top: 10px solid #044454; float:left; max-width: 210px;' ><tbody>";
    let closeTable = "</tbody></table>";

    let contentPlan = $('#planTable').html();

    let qty = "<tr><td><label for='planList" + i + ".qty'>qty:</label></td><td><input onkeyup='insertValue()' value='1' id='planList" + i + ".qty' name='planList[" + i + "].qty' type='number' class='form-control qty'></td></tr>";
    let operator = "<tr><td><label for='planList" + i + ".operator'>operator:</label></td><td><select id='planList" + i + ".operator' name='planList[" + i + "].operator' class='operator form-control'></select></td></tr>";

    document.getElementById("planTable").innerHTML = contentPlan + openTable + qty + operator + closeTable;

    document.getElementById("remove").innerHTML = "<button class='btn btn-outline-danger' id='btnRemove' onClick='rem(" + i + ")' type='button'>remove</button>";

    let operatorOption = document.getElementById("operator").innerHTML;

    $('.operator').each(function () {
        $(this).html(operatorOption);
    });
}