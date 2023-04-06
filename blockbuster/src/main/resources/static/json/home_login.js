// Al cargar la página
window.onload = function() {

    // Obtener la imagen de perfil
    var profileIcon = document.querySelector(".profile-icon");
  
    // Obtener el menú desplegable
    var profileMenu = document.querySelector(".profile-menu");
  
    // Al hacer clic en la imagen de perfil
    profileIcon.onclick = function() {
      profileMenu.classList.toggle("show");
    }
  
    // Al hacer clic en cerrar sesión
    var logoutButton = document.querySelector("#logout-button");
    logoutButton.onclick = function() {
      alert("Sesión cerrada");
    }
  
    // Si el usuario hace clic fuera del menú desplegable, se cierra
    window.onclick = function(event) {
      if (!event.target.matches('.profile-icon')) {
        if (profileMenu.classList.contains('show')) {
          profileMenu.classList.remove('show');
        }
      }
    }
  }