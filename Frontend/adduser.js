window.onload = function () {
    const form = document.getElementById("addUserForm");
    if (form) {
      form.addEventListener("submit", addUser);
    }
  };
  function addUser(event) {
    event.preventDefault();
  
    const fName = document.getElementById("fName").value;
    const lName = document.getElementById("lName").value;
    const emailId = document.getElementById("emailId").value;
    const phoneNo = document.getElementById("phoneNo").value;
  
    const queryParams = new URLSearchParams({ sno, fName, lName, emailId, phoneNo });
  
    fetch(`http://localhost:8080/users/add?${queryParams.toString()}`, {
      method: "POST",
    }).then(res => {
        if (res.ok) {
          alert("User added successfully!");
          window.location.href = "index.html"; // 🔁 Redirect to homepage
        } else {
          alert("Failed to add user.");
        }
      })
      .catch(err => {
        console.error("Error:", err);
        alert("An error occurred.");
      });
  }
  