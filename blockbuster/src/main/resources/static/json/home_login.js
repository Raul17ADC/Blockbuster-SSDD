const dropdownBtn = document.querySelector('.dropdown-btn');

dropdownBtn.addEventListener('click', function() {
  this.nextElementSibling.classList.toggle('show');
});

window.addEventListener('click', function(event) {
  if (!event.target.matches('.dropdown-btn')) {
    const dropdowns = document.getElementsByClassName('dropdown-content');
    for (let i = 0; i < dropdowns.length; i++) {
      const dropdown = dropdowns[i];
      if (dropdown.classList.contains('show')) {
        dropdown.classList.remove('show');
     }
}
}
});