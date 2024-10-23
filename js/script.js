function sendMessage() {
    var userMessage = document.getElementById("userMessage").value;
    var chatbox = document.getElementById("chatbox");
    
    // Display user message in the chatbox
    chatbox.innerHTML += '<div class="user-message">' + userMessage + '</div>';
    
    // Replace this with your chatbot logic to generate responses
    var botResponse = "This is a sample bot response.";
    
    // Display bot response in the chatbox
    chatbox.innerHTML += '<div class="bot-message">' + botResponse + '</div>';
    
    // Clear the input field
    document.getElementById("userMessage").value = "";
    
    // Scroll to the bottom of the chatbox
    chatbox.scrollTop = chatbox.scrollHeight;
}
