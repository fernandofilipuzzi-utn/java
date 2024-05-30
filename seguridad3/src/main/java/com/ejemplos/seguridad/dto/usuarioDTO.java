package com.ejemplos.seguridad.dto;

public class usuarioDTO 
{
    private String usuario;
    private String contraseña;

   public String getUsuario() {
       return usuario;
   }
   public String getContraseña() {
       return contraseña;
   }
   
   public usuarioDTO() {

   }
   
   public usuarioDTO(String usuario, String contraseña) {
       this.usuario = usuario;
       this.contraseña = contraseña;
   }
}