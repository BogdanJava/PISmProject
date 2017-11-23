const xmlFileName = "info.xml";

function loadXMLDoc(dname) {
    try //Internet Explorer
    {
        xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
    }
    catch (e) {
        try //Firefox, Mozilla, Opera, etc.
        {
            xmlDoc = document.implementation.createDocument("", "", null);
        }
        catch (e) {
            alert(e.message)
        }
    }
    try {
        xmlDoc.async = false;
        xmlDoc.load(dname);
        return (xmlDoc);
    }
    catch (e) {
        alert(e.message)
    }
    return (null)
}

function showXml(){
    var table = document.getElementById("tableBody");
    var xml = loadXMLDoc(xmlFileName);
    var xmlText = xml.xml;
    var trs = table.getElementsByTagName("tr");
    if(trs.length > 0){
        table.innerHTML = "";
    }
    parser = new DOMParser();
    var xmlDoc = parser.parseFromString(xmlText, "text/xml");

    var nodes = xmlDoc.getElementsByTagName("gradeReport")[0].getElementsByTagName("gradeList")[0]
        .getElementsByTagName("gradeRecord");

    for(var i=0; i<nodes.length; i++){

        var node = nodes.item(i);
        var id = i;
        var name = node.getElementsByTagName("student")[0].textContent;
        var mark = node.getElementsByTagName("grade")[0].textContent;

        var row = table.insertRow(i);
        var idCell = row.insertCell(0);
        var nameCell = row.insertCell(1);
        var markCell = row.insertCell(2);
        idCell.innerHTML = id;
        nameCell.innerHTML = name;
        markCell.innerHTML = mark;
    }
}

function changeDigits() {
    var table = document.getElementById("tableBody");
    var xml = loadXMLDoc(xmlFileName);
    var nodes = xml.getElementsByTagName("gradeReport")[0].getElementsByTagName("gradeList")[0]
        .getElementsByTagName("gradeRecord");

    for(var i=0; i<nodes.length; i++) {
        var node = nodes.item(i);
        var gradeCell = table.getElementsByTagName("td")[i];
        var grade = node.childNodes[1];

        document.write("hui");

        switch (grade){
            case "1": grade.nodeValue = "Один"; break;
            case "2": grade.nodeValue = "Два"; break;
            case "3": grade.nodeValue = "Три"; break;
            case "4": grade.nodeValue = "Четыре"; break;
            case "5": grade.nodeValue = "Пять"; break;
        }
    }

}