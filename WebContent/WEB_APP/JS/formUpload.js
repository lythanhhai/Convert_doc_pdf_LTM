const form = document.querySelector(".wrapper__form"),
fileInput = document.querySelector(".wrapper__form-file"),
progressArea = document.querySelector(".progress-area"),
uploadedArea = document.querySelector(".uploaded-area"),
wrapper__submit = document.querySelector(".wrapper__submit");
var uploadedHTML = "";

wrapper__submit.addEventListener("click", () =>{
  form.submit();
});

form.addEventListener("click", () =>{
  fileInput.click();
});



fileInput.onchange = ({ target })=>{
  uploadedHTML = "";
  //let file = target.files[0];
  let files = target.files;
  //alert(files.length);
  if(files.length === 1)
  {
		  if(files[0]){
			  let fileName = files[0].name;
			  if(fileName.length >= 12){
				  let splitName = fileName.split('.');
				  fileName = splitName[0].substring(0, 13) + "... ." + splitName[1];
			  }
			  uploadFile(fileName);
          }	
  }
  else 
  {
	  for(var i = 0 ; i < files.length ; i++)
	  {
		  if(files[i]){
			  //alert(files[i].name);
			  let fileName = files[i].name;
			  if(fileName.length >= 12){
				  let splitName = fileName.split('.');
				  fileName = splitName[0].substring(0, 13) + "... ." + splitName[1];
			  }
			  uploadFile(fileName);
		  }	
	  }
	  
  }

}


function uploadFile(name){
	  progressArea.innerHTML = "";
      uploadedHTML += `<li class="row">
                            <div class="content upload">
                              <i class="fas fa-file-alt"></i>
                              <div class="details">
                                <span class="name">${name} • Uploaded</span>
                                
                              </div>
                            </div>
                            <i class="fas fa-check"></i>
                          </li>`;
      //uploadedArea.insertAdjacentHTML("afterbegin", uploadedHTML);
      uploadedArea.innerHTML = uploadedHTML;
      //<i class="fas fa-times"></i>

}













function uploadFile1(name){
	  let xhr = new XMLHttpRequest();
	  xhr.open("POST", "php/upload.php");
	  xhr.upload.addEventListener("progress", ({loaded, total}) =>{
	    let fileLoaded = Math.floor((loaded / total) * 100);
	    let fileTotal = Math.floor(total / 1000);
	    let fileSize;
	    (fileTotal < 1024) ? fileSize = fileTotal + " KB" : fileSize = (loaded / (1024*1024)).toFixed(2) + " MB";
	    let progressHTML = `<li class="row">
	        <i class="fas fa-file-alt"></i>
	        <div class="content">
	          <div class="details">
	            <span class="name">${name} • Uploading</span>
	            <span class="percent">${fileLoaded}%</span>
	          </div>
	          <div class="progress-bar">
	            <div class="progress" style="width: ${fileLoaded}%"></div>
	          </div>
	        </div>
	      </li>`;
	    uploadedArea.classList.add("onprogress");
	    progressArea.innerHTML = progressHTML;
	    if(loaded == total){
	      progressArea.innerHTML = "";
	      let uploadedHTML = `<li class="row">
	                            <div class="content upload">
	                              <i class="fas fa-file-alt"></i>
	                              <div class="details">
	                                <span class="name">${name} • Uploaded</span>
	                                <span class="size">${fileSize}</span>
	                              </div>
	                            </div>
	                            <i class="fas fa-check"></i>
	                          </li>`;
	      uploadedArea.classList.remove("onprogress");
	      uploadedArea.insertAdjacentHTML("afterbegin", uploadedHTML);
	    }
	  });
	  let data = new FormData(form);
	  xhr.send(data);
	}