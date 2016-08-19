
/**
 * Created by Dilipan on 6/25/2016.
 */


function PreviewImage() {
    
    var oFReader = new FileReader();
    oFReader.readAsDataURL(document.getElementById("upload").files[0]);

    oFReader.onload = function (oFREvent) {
        alert(document.getElementById("preview"));

        document.getElementById("preview").src = oFREvent.target.result;
    };
};





    