// function for onclick of button to show the details on the console
function display(){
    
    let name=document.getElementById("fullname").value;
    console.log("Name: "+name);
    let dob=document.getElementById("dob").value;
    console.log("DOB: "+dob);
    let email=document.getElementById("email").value;
    console.log("Email: "+email);
    let mobile=document.getElementById("mobile").value;
    console.log("Mobile: "+mobile);
    let gender=document.getElementById("gender").value;
    console.log("Gender: "+gender);
    let occupation=document.getElementById("occupation").value;
    console.log("Occupation: "+occupation);
    let id_type=document.getElementById("id_type").value;
    console.log("ID Type: "+id_type);
    let id_num=document.getElementById("id_num").value;
    console.log("ID Number: "+id_num);
    let issue_auth=document.getElementById("issue_auth").value;
    console.log("Issue Authority: "+issue_auth);
    let issue_date=document.getElementById("issue_date").value;
    console.log("Issue Date: "+issue_date);
    let issue_state=document.getElementById("issue_state").value;
    console.log("Issue State: "+issue_state);
    let expiry_date=document.getElementById("expiry_date").value;
    console.log("Expiry Date: "+expiry_date);

    // redirecting to the thank you page on click of next button
    window.location.href="thanks.html";

}

