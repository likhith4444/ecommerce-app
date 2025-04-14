document.getElementById("registerForm").addEventListener("submit", function (e) {
    e.preventDefault();
  
    const data = {
      username: document.getElementById("username").value,
      email: document.getElementById("email").value,
      password: document.getElementById("password").value
    };
  
    fetch("http://localhost:8080/api/users", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(data)
    })
      .then(res => res.json())
      .then(data => {
        document.getElementById("registerStatus").innerText = "✅ Registered successfully!";
        document.getElementById("registerForm").reset();
      })
      .catch(err => {
        console.error(err);
        document.getElementById("registerStatus").innerText = "❌ Registration failed.";
      });
  });
  