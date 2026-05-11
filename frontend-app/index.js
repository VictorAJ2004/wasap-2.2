import axios from 'https://cdn.skypack.dev/axios'; 

const cargarDatos = async () => {
    const statusElement = document.getElementById('status-p');
    
    try {
        // Llamada al BFF en el puerto 8080
        const res = await axios.get('http://localhost:8080/api/v1/chat/dashboard');
        
        console.log("Datos unificados del BFF:", res.data);

        // Si la conexión es exitosa, actualizamos el mensaje en la web
        if (statusElement) {
            statusElement.innerText = "¡Conexión con el BFF establecida correctamente!";
            statusElement.className = "success";
        }

    } catch (error) {
        console.error("Error conectando al BFF", error);
        
        // Si hay un error, informamos al usuario
        if (statusElement) {
            statusElement.innerText = "Error: No se pudo conectar con el servidor.";
            statusElement.className = "error";
        }
    }
};

cargarDatos();