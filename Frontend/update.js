window.onload = function () {
  const params = new URLSearchParams(window.location.search);
  const sno = params.get("sno");

  if (sno) {
    fetch(`http://localhost:8080/users/${sno}`)
      .then(res => res.json())
      .then(user => {
        document.getElementById("sno").value = user.sno;
        document.getElementById("fName").value = user.fName;
        document.getElementById("lName").value = user.lName;
        document.getElementById("emailId").value = user.emailId;
        document.getElementById("phoneNo").value = user.phoneNo;
      });
  }
};

function updateUser(event) {
  event.preventDefault();

  const sno = document.getElementById("sno").value;
  const fName = document.getElementById("fName").value;
  const lName = document.getElementById("lName").value;
  const emailId = document.getElementById("emailId").value;
  const phoneNo = document.getElementById("phoneNo").value;

  const queryParams = new URLSearchParams({ sno, fName, lName, emailId, phoneNo });

  fetch(`http://localhost:8080/users/update?${queryParams.toString()}`, {
    method: "PUT",
  }).then(res => {
    if (res.ok) {
      alert("User updated");
      window.location.href = "index.html";
    } else {
      alert("Update failed");
    }
  });
}
