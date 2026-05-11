import axios from 'axios';

const cargarDatos = async () => {
    try {
        const res = await axios.get('http://localhost:8080/api/v1/chat/dashboard');
        console.log("Datos unificados del BFF:", res.data);
    } catch (error) {
        console.error("Error conectando al BFF", error);
    }
};

cargarDatos();