let i = 0;

function rem(n){
    let id = "tb" + n;
    $("#"+id).remove();
    i = i - 1;

    if (i < 1){
        document.getElementById("remove").style.display = "none";
    }

    document.getElementById("remove").innerHTML = "<button class='btn btn-outline-danger' onClick='rem("+i+")' type='button'>remove</button>";
}

function add() {
    i++;

    document.getElementById("remove").style.display = 'block';

    let openTable = "<table id='tb" + i + "'><tbody>";
    let closeTable = "</tbody></table>";

    let contentPlan = $('#planTable').html();

    let sku = "<tr><td><label for='planList" + i + ".sku'>sku:</label></td><td><select class='sku form-control' id='planList" + i + ".sku' name='planList[" + i + "].sku' class='form-control'></select></td></tr>";
    let qty = "<tr><td><label for='planList" + i + ".qty'>qty:</label></td><td><input value='1' id='planList" + i + ".qty' name='planList[" + i + "].qty' type='number' class='form-control'></td></tr>";
    let option = "<tr><td><label for='planList" + i +".status'>status:</label></td><td><select id='planList" + i +".status' name='planList[" + i +"].status' class='form-control'><option value='ITC'>ITC</option><option value='FIXING'>FIXING</option><option value='TECHLAB'>TECHLAB</option><option value='TESTING'>TESTING</option><option value='PACKING'>PACKING</option></select></td></tr>";

    document.getElementById("planTable").innerHTML = contentPlan + openTable + sku + qty + option + closeTable;

    document.getElementById("remove").innerHTML = "<button class='btn btn-outline-danger' onClick='rem("+i+")' type='button'>remove</button>";

    let skuOption = document.getElementById("sku").innerHTML;

    $('.sku').each(function (){
        $(this).html(skuOption);
    });
}