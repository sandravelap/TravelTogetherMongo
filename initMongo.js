/*
Cambios Clave con respecto a la estructura relacional:

Desnormalización: Se ha eliminado la tabla Participacion.
Ahora los participantes son un simple array dentro del documento Viaje.
Esto cumple con la gestión de objetos estructurados.

Anidamiento de Etapas: Etapas dentro de Viaje,
recuperamos toda la información de la ruta en una sola lectura de disco.


Geopespacial: Conversión de las coordenadas X e Y a un objeto GeoJSON (Point),
permite realizar consultas por cercanía en el futuro.

Lógica de Triggers: MongoDB no usa triggers SQL tradicionales para validación simple.
La validación de que la fechaInicio sea posterior a la actual debe gestionarse
ahora en la capa de aplicación o mediante JSON Schema Validation en la colección.

 */

// Seleccionar o crear la base de datos
use('traveltogether');

// 1. Colección de Usuarios
db.Usuario.insertMany([
    {
        "alias": "carlos_picos",
        "nombre": "Carlos Rodríguez",
        "correo": "carlos.rodriguez@email.com",
        "pass": "$2b$12$K9R.B8u5fG8...",
        "tabaco": "fumador",
        "mascota": "compañia"
    },
    {
        "alias": "ana_rioja",
        "nombre": "Ana Martínez",
        "correo": "ana.mtz@email.com",
        "pass": "$2b$12$L0X.A7v2hH1...",
        "tabaco": "tolerante",
        "mascota": "tolerante"
    },
    {
        "alias": "javi_montaña",
        "nombre": "Javier López",
        "correo": "javi.lpz@email.com",
        "pass": "$2b$12$M1Y.C3w9jI2...",
        "tabaco": "intolerante",
        "mascota": "intolerante"
    },
    {
        "alias": "marta_senderos",
        "nombre": "Marta Gómez",
        "correo": "marta.g@email.com",
        "pass": "$2b$12$S7E.I9c3pP8...",
        "tabaco": "null",
        "mascota": "compañia"
    },
    {
        "alias": "lucia_furgo",
        "nombre": "Lucía García",
        "correo": "lucia.garcia@email.com",
        "pass": "$2b$12$N2Z.D4x8kJ3...",
        "tabaco": "fumador",
        "mascota": "compañia"
    },
    {
        "alias": "pablo_camino",
        "nombre": "Pablo Herranz",
        "correo": "pablo.h@email.com",
        "pass": "$2b$12$T8F.J0d2qQ9...",
        "tabaco": "tolerante",
        "mascota": "null"
    },
    {
        "alias": "marcos_aneto",
        "nombre": "Marcos Soler",
        "correo": "marcos.soler@email.com",
        "pass": "$2b$12$O3A.E5y7lK4...",
        "tabaco": "intolerante",
        "mascota": "intolerante"
    },
    {
        "alias": "sergio_cadiz",
        "nombre": "Sergio Ruiz",
        "correo": "sergio.ruiz@email.com",
        "pass": "$2b$12$P4B.F6z6mL5...",
        "tabaco": "fumador",
        "mascota": "asistencia"
    },
    {
        "alias": "raquel_winelover",
        "nombre": "Raquel Díaz",
        "correo": "raquel.d@email.com",
        "pass": "$2b$12$U9G.K1e1rR0...",
        "tabaco": "tolerante",
        "mascota": "tolerante"
    },
    {
        "alias": "ivan_alpinista",
        "nombre": "Iván Torres",
        "correo": "ivan.t@email.com",
        "pass": "$2b$12$V0H.L2f0sS1...",
        "tabaco": "intolerante",
        "mascota": "null"
    },
    {
        "alias": "elena_vinitos",
        "nombre": "Elena Sanz",
        "correo": "elena.sanz@email.com",
        "pass": "$2b$12$Q5C.G7a5nM6...",
        "tabaco": "null",
        "mascota": "compañia"
    },
    {
        "alias": "pedro_rioja",
        "nombre": "Pedro Cano",
        "correo": "pedro.c@email.com",
        "pass": "$2b$12$W1I.M3g9tT2...",
        "tabaco": "tolerante",
        "mascota": "tolerante"
    },
    {
        "alias": "sofia_gastronomia",
        "nombre": "Sofía Varga",
        "correo": "sofia.v@email.com",
        "pass": "$2b$12$X2J.N4h8uU3...",
        "tabaco": "fumador",
        "mascota": "compañia"
    },
    {
        "alias": "david_alpin",
        "nombre": "David Peña",
        "correo": "david.p@email.com",
        "pass": "$2b$12$R6D.H8b4oN7...",
        "tabaco": "intolerante",
        "mascota": "intolerante"
    }

    // ... rest of users
]);

// 2. Colección de Destinos (Incluyendo sus recomendaciones anidadas)
db.Destino.insertMany([
    {
        "alias_destino": "picos-europa",
        "nombre": "Picos de Europa",
        "descripcion": "Parque Nacional en los Picos de Europa",
        "ubicacion": { "type": "Point", "coordinates": [-4.820179, 43.189094] },
        "dificultad": 3,
        "recomendaciones": [
            { "nombre": "Guía de montaña certificado", "descuento": 10.00 }
        ]
    },
    {
        "alias_destino": "tarifa-beach",
        "nombre": "Tarifa",
        "descripcion": "Punto de encuentro entre el Atlántico y el Mediterráneo, ideal para deportes de viento.",
        "ubicacion": { "type": "Point", "coordinates": [-5.6033, 36.0127] },
        "dificultad": 1,
        "recomendaciones": [
            { "nombre": "Curso de iniciación al Kitesurf", "descuento": 15.00 },
            { "nombre": "Alquiler de neopreno", "descuento": 5.00 }
        ]
    },
    {
        "alias_destino": "playa-bolonia",
        "nombre": "Playa de Bolonia",
        "descripcion": "Famosa por su duna gigante y las ruinas romanas de Baelo Claudia.",
        "ubicacion": { "type": "Point", "coordinates": [-5.7738, 36.0889] },
        "dificultad": 1,
        "recomendaciones": [
            { "nombre": "Entrada Museo Baelo Claudia", "descuento": 100.00 }
        ]
    },
    {
        "alias_destino": "refugio-renclusa",
        "nombre": "Refugio de la Renclusa",
        "descripcion": "Refugio base emblemático para las ascensiones en el macizo de la Maladeta.",
        "ubicacion": { "type": "Point", "coordinates": [0.6508, 42.6694] },
        "dificultad": 3,
        "recomendaciones": [
            { "nombre": "Media pensión en refugio", "descuento": 5.00 }
        ]
    },
    {
        "alias_destino": "cima-aneto",
        "nombre": "Cima Aneto",
        "descripcion": "El punto más alto de los Pirineos (3.404m) cruzando el Glaciar y el Paso de Mahoma.",
        "ubicacion": { "type": "Point", "coordinates": [0.6568, 42.6321] },
        "dificultad": 5,
        "recomendaciones": [
            { "nombre": "Alquiler de crampones y piolet", "descuento": 12.00 }
        ]
    },
    {
        "alias_destino": "laurel-logrono",
        "nombre": "Calle Laurel (Logroño)",
        "descripcion": "La zona de pinchos y tapeo más famosa de la capital riojana.",
        "ubicacion": { "type": "Point", "coordinates": [-2.4474, 42.4655] },
        "dificultad": 1,
        "recomendaciones": [
            { "nombre": "Ticket 'Pincho + Corto' x5", "descuento": 15.00 }
        ]
    },
    {
        "alias_destino": "bodegas-haro",
        "nombre": "Bodegas Haro",
        "descripcion": "Visita al Barrio de la Estación, cuna de las bodegas históricas de Rioja.",
        "ubicacion": { "type": "Point", "coordinates": [-2.8475, 42.5833] },
        "dificultad": 1,
        "recomendaciones": [
            { "nombre": "Cata premium de 3 vinos", "descuento": 20.00 }
        ]
    }
]);

// 3. Colección de Viajes (El "corazón" de la migración)
// En lugar de una tabla Participacion y Etapa, anidamos los arrays.
db.Viaje.insertMany([
    {
        "nombre": "Ruta por los Picos",
        "descripcion": "Excursión de 3 días por los Picos de Europa",
        "aliasCreador": "carlos_picos",
        "maxParticipantes": 6,
        "fecha_inicio": ISODate("2026-01-23T09:00:00Z"),
        "fecha_fin": ISODate("2026-01-25T18:00:00Z"),
        "tabaco": true,
        "mascota": "compañia",
        "participantes": ["carlos_picos", "javi_montaña", "marta_senderos"],
        "etapas": [
            {
                "aliasDestino": "picos-europa",
                "nombreDestino": "Picos de Europa",
                "horaInicio": "09:00",
                "duracionMinutos": 300
            }
        ]
    },
    {
        "nombre": "Cima del Pirineo",
        "descripcion": "Ascenso técnico al Aneto desde el refugio",
        "aliasCreador": "marcos_aneto",
        "maxParticipantes": 4,
        "fecha_inicio": ISODate("2026-06-12T06:00:00Z"),
        "fecha_fin": ISODate("2026-06-14T20:00:00Z"),
        "tabaco": false,
        "mascota": "intolerante",
        "participantes": ["marcos_aneto", "david_alpin", "ivan_alpinista"],
        "etapas": [
            {
                "aliasDestino": "refugio-renclusa",
                "nombreDestino": "Refugio de la Renclusa",
                "horaInicio": "14:00",
                "duracionMinutos": 240
            },
            {
                "aliasDestino": "cima-aneto",
                "nombreDestino": "Cima Aneto",
                "horaInicio": "05:00",
                "duracionMinutos": 480
            }
        ]
    },
    {
        "nombre": "Cata y Tapas Riojanas",
        "descripcion": "Ruta de fin de semana por Logroño y Haro",
        "aliasCreador": "ana_rioja",
        "maxParticipantes": 12,
        "fecha_inicio": ISODate("2026-04-10T19:00:00Z"),
        "fecha_fin": ISODate("2026-04-12T16:00:00Z"),
        "tabaco": true,
        "mascota": "tolerante",
        "participantes": ["ana_rioja", "pablo_camino", "raquel_winelover", "pedro_rioja", "sofia_gastronomia", "elena_vinitos"],
        "etapas": [
            {
                "aliasDestino": "laurel-logrono",
                "nombreDestino": "Calle Laurel (Logroño)",
                "horaInicio": "20:30",
                "duracionMinutos": 180
            },
            {
                "aliasDestino": "bodegas-haro",
                "nombreDestino": "Bodegas Haro",
                "horaInicio": "11:30",
                "duracionMinutos": 150
            }
        ]
    }
]);

// Creación de índices para optimizar búsquedas [cite: 79]
db.Usuario.createIndex({ "alias": 1 }, { unique: true });
db.Destino.createIndex({ "alias_destino": 1 }, { unique: true })
db.Destino.createIndex({ "ubicacion": "2dsphere" }); // Índice geoespacial