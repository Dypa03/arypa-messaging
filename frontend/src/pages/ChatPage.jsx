


export default function ChatPage(props) {
    var stompClient = null;
    var currentChatId = null;

    function connect(chatId) {
        console.log(chatId)
        currentChatId = chatId
        var socket = new SockJs('/ws')
    }

    return (
        <>
            <main>
                <input type="text" name="chatId" id="chatId" />
                <button onclick='connect(document.getElementById("chatId").value)'>Choose</button>


                <div id="chatroom">
                    <h1>Chatroom</h1>
                    <div id="messages"></div>
                    <input type="text" id="message-input" placeholder="Type a message..." />
                    <button onclick="sendMessage()">Send</button>
                </div>
            </main>
        </>
    )

}