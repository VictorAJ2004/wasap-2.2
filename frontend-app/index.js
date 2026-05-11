import axios from 'https://cdn.skypack.dev/axios'; 

const cargarDatos = async () => {
    const statusElement = document.getElementById('status-p');
    
    try {
        // llama al bff en el puerto 8080
        const res = await axios.get('http://localhost:8080/api/v1/chat/dashboard');
        
        console.log("Datos unificados del BFF:", res.data);

        // si se conecta con exito, se muestra un mensaje de éxito al usuario
        if (statusElement) {
            statusElement.innerText = "¡Conexión con el BFF establecida correctamente!";
            statusElement.className = "success";
        }

    } catch (error) {
        console.error("Error conectando al BFF", error);
        
        // si hay un error, se muestra un mensaje de error al usuario
        if (statusElement) {
            statusElement.innerText = "Error: No se pudo conectar con el servidor.";
            statusElement.className = "error";
        }
    }
};

const enviarMensaje = async () => {
    const input = document.getElementById('message-input');
    const texto = input.value;

    if (!texto) return;

    try {
        await axios.post('http://localhost:8080/api/v1/chat/send', {
            userId: 1, // id de usuario (pruebas)
            text: texto
        });
        
        input.value = ''; 
        alert("Mensaje enviado y guardado en la DB");
        location.reload(); 
    } catch (error) {
        console.error("Error al enviar", error);
    }
};

document.getElementById('send-btn').addEventListener('click', enviarMensaje);

cargarDatos();