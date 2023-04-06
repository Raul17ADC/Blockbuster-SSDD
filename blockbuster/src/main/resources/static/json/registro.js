const form = document.querySelector("#register-form");
const emailInput = document.querySelector("#email");
const usernameInput = document.querySelector("#username");
const passwordInput = document.querySelector("#password");
const registerButton = document.querySelector("#register-button");

form.addEventListener("submit", (event) => {
  event.preventDefault();

  const email = emailInput.value;
  const username = usernameInput.value;
  const password = passwordInput.value;

  // TODO: Enviar datos del formulario al servidor para registrar el usuario

  console.log(`Email: ${email}`);
  console.log(`Nombre de Usuario: ${username}`);
  console.log(`Contraseña: ${password}`);
});

const registerForm = document.getElementById("register-form");
const confirmMessage = document.getElementById("confirm-message");
const goHomeButton = document.getElementById("go-home");

registerForm.addEventListener("submit", (event) => {
  event.preventDefault();
  confirmMessage.innerHTML = "Perfecto, ya te has registrado";
  goHomeButton.style.display = "block";
});
