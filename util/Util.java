package com.tempus.tempusoftware.serpapas.util;
/**
 * Creado por Galder on 2019
 * TempusSoftwares
 * sexoductor@gmail.com
 * Todos los derechos reservados
 */

public class Util {

    public final static String

    //MENU
            ADD_MENU = "Add",
            BAÑO_MENU = "Baño",
            PASEO_MENU = "Paseo",
            ROPA_MENU = "Ropa",
            COMIDA_MENU = "Comida",
            CASA_MENU = "Casa",
            TIENE_MENU = "Tiene",
            FALTA_MENU = "Falta",
            CUENTATRAS_MENU = "Cuenta",
            OPCIONES = "Opciones",
            LEGAL = "Legal",

    //DATABASE
            BD = "listabebe",
            TABLA_BD = "bebe",
            PRODUCTO = "producto",
            DONDE = "donde",
            QUIEN = "quien",
            CANTIDAD = "cantidad",
            CATEGORIA = "categoria",
            LOTENGO = "lotengo",
            SI = "SI",
            NO = "NO",

    //DATABASE_QUERYS
            QUERY_ALL = "select * from bebe",
            QUERY_ON_DEPENDS = "select * from bebe where lotengo = 'SI' and categoria = ",
            QUERY_FALTA = "select * from bebe where lotengo = 'NO'",
            QUERY_TENGO = "select * from bebe where lotengo = 'SI'",
            QUERY_CATEGORY = "select * from bebe where categoria = ",
            QUERY_ID = "select * from bebe where id = ",
            QUERY_CATEGORY_BAÑO = "select * from bebe where categoria = 'Baño'",
            QUERY_CATEGORY_ROPA = "select * from bebe where categoria = 'Ropa'",
            QUERY_CATEGORY_CASA = "select * from bebe where categoria = 'Casa'",
            QUERY_CATEGORY_COMIDA = "select * from bebe where categoria = 'Comida'",
            QUERY_CATEGORY_PASEO = "select * from bebe where categoria = 'Paseo'",

    //CATEGORIAS
            CATEGORIA_BAÑO = "'Baño'",
            CATEGORIA_ROPA = "'Ropa'",
            CATEGORIA_CASA = "'Casa'",
            CATEGORIA_COMIDA = "'Comida'",
            CATEGORIA_PASEO = "'Paseo'",



    //MENSAJES
            MSG_REGISTRO_OK = "El registro se ha guardado",
            MSG_CAMPOS_KO = "Debes rellenar los campos vacíos",
            MSG_ADVERTENCIA_BORRADO = "ADVERTENCIA: Si no se ha realizado una copia de seguridad de la base de datos perderás todos los productos que hayas introducido. Te recomendamos primero hacer una copia de seguridad de los datos en la tarjeta SD",
            MSG_BORRAR_BASEDEDATOS = "Borrar la Base de Datos",
            MSG_BASEDEDATOS_BORRADA = "La Base de Datos ha sido borrada",
            MSG_SI = "Sí",
            MSG_NO = "No",

    //ACTIONBAR
            ACTIONBAR_BAÑO_TITLE = "Para el Baño",
            ACTIONBAR_ROPA_TITLE = "Su Ropa",
            ACTIONBAR_CASA_TITLE = "Para la Casa",
            ACTIONBAR_COMIDA_TITLE = "Para la Comida",
            ACTIONBAR_PASEO_TITLE = "Para el Paseo",
            ACTIONBAR_SUBTITLE = "Todo lo que ya tengo",

    //NOTAS
            NOTA_DONDE_COMPRE = "¿Dónde lo compré?",
            NOTA_SIN_NOTAS = "Sin Notas";

}
