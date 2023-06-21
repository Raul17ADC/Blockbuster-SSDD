const createFilmForm = document.querySelector("#create-film-form");
const confirmMessage = document.querySelector("#confirm-message");
const goHomeButton = document.querySelector("#go-home");

createFilmForm.addEventListener("submit", (event) => {
  event.preventDefault();

  const title = document.querySelector("#title").value;
  const director = document.querySelector("#director").value;
  const scriptwriter = document.querySelector("#scriptwriter").value;
  const trailer = document.querySelector("#trailer").value;
  const description = document.querySelector("#description").value;
  const image = document.querySelector("#image").value;
  const rating = document.querySelector("#rating").value;

  // Send film data to server to create a new film
  const filmData = {
    title,
    director,
    scriptwriter,
    trailer,
    description,
    image,
    rating
  };

  fetch("/films/create", {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(filmData)
  })
  .then(response => response.json())
  .then(data => {
    confirmMessage.innerHTML = "¡Película creada exitosamente!";
    goHomeButton.style.display = "block";
    console.log(data);
  })
  .catch(error => {
    console.error("Error:", error);
  });
});