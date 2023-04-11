const form = document.querySelector("#register-form");
const usernameInput = document.querySelector("#username");
const passwordInput = document.querySelector("#password");
const registerButton = document.querySelector("#login-button");

form.addEventListener("submit", (event) => {
  event.preventDefault();

  const email = emailInput.value;
  const username = usernameInput.value;
  const password = passwordInput.value;

  // ALL: Send form data to server to register user

  console.log(`Nombre de Usuario: ${username}`);
  console.log(`Contraseña: ${password}`);
});

const registerForm = document.getElementById("register-form");
const confirmMessage = document.getElementById("confirm-message");
const goHomeButton = document.getElementById("go-home");

registerForm.addEventListener("submit", (event) => {
  event.preventDefault();
  confirmMessage.innerHTML = "¡ Has accedido con exito !";
  goHomeButton.style.display = "block";
});
