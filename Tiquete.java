package uniandes.dpoo.aerolinea.modelo;

import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public class Tiquete {
 private Cliente cliente;
 private java.lang.String codigo;
 private int tarifa;
 private boolean usado;
 private Vuelo vuelo;

 public Tiquete(String codigo, Vuelo vuelo, Cliente clienteComprador, int tarifa) {
     this.codigo = codigo;
     this.vuelo = vuelo;
     this.cliente = clienteComprador;
     this.tarifa = tarifa;
     this.usado = false;
     clienteComprador.agregarTiquete​(this);
 }
 public Cliente getCliente() {
     return cliente;
 }

 public String getCodigo() {
     return codigo;
 }

 public int getTarifa() {
     return tarifa;
 }

 public Vuelo getVuelo() {
     return vuelo;
}
 public boolean esUsado() {
     return usado;
 }

 public void marcarComoUsado() {
     this.usado = true;
 }

}