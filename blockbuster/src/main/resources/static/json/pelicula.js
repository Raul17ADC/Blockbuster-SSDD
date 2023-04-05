const submitButton = document.getElementById("submit-button");
const commentInput = document.getElementById("comment-input");
const commentsContainer = document.getElementById("comments-container");

submitButton.addEventListener("click", function() {
  const comment = commentInput.value;
  const commentElement = document.createElement("div");
  commentElement.innerHTML = comment;
  commentsContainer.appendChild(commentElement);
  commentInput.value = "";
});