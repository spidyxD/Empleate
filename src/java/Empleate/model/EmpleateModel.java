
/*Basado en un proyecto de Andres Cascante*/
package Empleate.model;

import Empleate.database.Database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class EmpleateModel{

    static Database BD;

    static {
        initCiudades();
    }

    private static void initCiudades() {
        BD = new Database(null, null, null);
    }

//    public static List<Ciudad> getCiudades1() {
//        List<Ciudad> ciudades;
//        ciudades = new ArrayList();
//        try {
//            String sql = "select * "
//                    + "from ciudad  c  ";
//            ResultSet rs = BD.executeQuery(sql);
//            while (rs.next()) {
//                ciudades.add(toCiudad(rs));
//            }
//        } catch (SQLException ex) {
//        }
//        return ciudades;
//    }
//    
//    public int saveTicket(Tiquete ticket, String[] seats) throws SQLException, Exception {
//        String delimiter=": ";
//        String[] temp;
//        temp = ticket.getCliente().getCedula().split(delimiter);
//        String cedula= clientGet(temp[1]).getCedula();
//        String sql = "insert into tiquete values ('%s','%s','%s')";
//        int rs2=0;
//        sql = String.format(sql, cedula,ticket.getVuelo().getCodigo_Vuelo(),ticket.getCodigo_Tiquete());
//        int rs = BD.executeUpdate(sql);
//        for (String seat : seats) {
//            String sql2 = "insert into asiento values ('%s', '%s', '%s')";
//            sql2 = String.format(sql2, seat, ticket.getCodigo_Tiquete(), ticket.getVuelo().getAvion().getCodigo_Avion());
//            rs2 = BD.executeUpdate(sql2);
//        }
//        if(rs==1 && rs2==1)
//            return 1;
//        else
//            return 0; 
//    }
//
//    public List<Asiento> getAsientos(String avion){
//        List<Asiento> asientos;
//        asientos = new ArrayList();
//        try{
//            String sql = "select * from asiento where codigo_avion = '%s'";
//            sql = String.format(sql, avion);
//            ResultSet rs = BD.executeQuery(sql);
//            while(rs.next()){
//                Asiento seat = new Asiento();
//                seat.setNumero(rs.getString("numero"));
//                String tiquete = rs.getString("codigo_tiquete");
//                String sql2 = "select * from tiquete where codigo_tiquete = '%s'";
//                sql2 = String.format(sql2, tiquete);
//                ResultSet rs2 = BD.executeQuery(sql2);
//                while(rs2.next()){
//                    Tiquete tiq = toTiquete(rs2);
//                    seat.setTiquete(tiq);
//                }
//                String avi = rs.getString("codigo_avion");
//                String sql3 = "select * from avion where codigo_avion = '%s'";
//                sql3 = String.format(sql3, avi);
//                ResultSet rs3 = BD.executeQuery(sql3);
//                while(rs3.next()){
//                    Avion plane = toAvion(rs3);
//                    seat.setAvion(plane);
//                }
//                asientos.add(seat);
//            }
//        }
//        catch(SQLException e){
//            System.err.println(e.getMessage());
//        }
//        return asientos;
//    }
//    
//    private Tiquete toTiquete(ResultSet rs) throws SQLException{
//        Tiquete tiquete = new Tiquete();
//        String cliente = rs.getString("cedula_cliente");
//        String codigo_vuelo = rs.getString("codigo_vuelo");
//        String codigo_tiquete = rs.getString("codigo_tiquete");
//        String sql = "select * from usuario where cedula = '%s'";
//        sql = String.format(sql, cliente);
//        ResultSet rs1 = BD.executeQuery(sql);
//        List<Vuelo> vuelos = this.getVuelos1();
//        Vuelo vuelo = new Vuelo();
//        for(int i=0; i < vuelos.size() ; i++){
//            if(vuelos.get(i).getCodigo_Vuelo().contains(codigo_vuelo))
//                vuelo = vuelos.get(i);
//        }
//        while(rs1.next()){
//            try {
//                Usuario c  = toClient(rs1);
//                tiquete.setCliente(c);   
//                 } 
//            catch (Exception ex) 
//            {
//                System.err.println(ex.getMessage());
//            }
//        }
//        tiquete.setVuelo(vuelo);
//        tiquete.setCodigo_Tiquete(codigo_tiquete);
//        return tiquete;
//    }
//    
//    private static Ciudad toCiudad(ResultSet rs) {
//        try {
//            Ciudad obj = new Ciudad();
//            obj.setCodigo_ciudad(rs.getString("codigo_ciudad"));
//            obj.setNombre(rs.getString("nombre"));
//            obj.setPais(rs.getString("pais"));
//            return obj;
//        } catch (SQLException ex) {
//            return null;
//        }
//    }
//
//    public List<Ciudad> getCiudades() {
//        Ciudad[] ciudades = {
//            new Ciudad("SJO", "San Jose", "Costa Rica"),
//            new Ciudad("LIB", "Guanacaste", "Costa Rica"),
//            new Ciudad("MIA", "Miami", "USA"),
//            new Ciudad("CAN", "Cancun", "MEXICO"),
//            new Ciudad("ORL", "Orlando", "USA"),
//            new Ciudad("PAN", "Panama", "Panama")};
//        return new ArrayList(Arrays.asList(ciudades));
//    }
//
//    public List<Vuelo> getVuelos() {
//        List<Ciudad> ciudades = new ArrayList(this.getCiudades());
//        Ruta[] rutas = {
//            /* 0 */new Ruta("111", ciudades.get(0), ciudades.get(4), "2"),
//            /* 1 */ new Ruta("222", ciudades.get(2), ciudades.get(4), "8"),
//            /* 2 */ new Ruta("333", ciudades.get(1), ciudades.get(2), "3"),
//            /* 3 */ new Ruta("444", ciudades.get(3), ciudades.get(5), "10"),
//            /* 4 */ new Ruta("555", ciudades.get(4), ciudades.get(2), "2"),
//            /* 5 */ new Ruta("666", ciudades.get(4), ciudades.get(2), "5"),
//            /* 6 */ new Ruta("777", ciudades.get(1), ciudades.get(2), "7"),
//            /* 7 */ new Ruta("888", ciudades.get(5), ciudades.get(1), "1"),
//            /* 8 */ new Ruta("999", ciudades.get(3), ciudades.get(4), "5"),
//            /* 9 */ new Ruta("101010", ciudades.get(1), ciudades.get(2), "5"),};
//        Avion[] aviones = {
//            /* 0 */new Avion("01", "Toyota", "Avianka", 100, 10, 10),
//            /* 1 */ new Avion("02", "Hyundai", "Aeromexican", 200, 20, 10),
//            /* 2 */ new Avion("03", "Ford", "Colon", 150, 15, 10),
//            /* 3 */ new Avion("04", "Chevrolet", "Lavara", 100, 10, 10)
//        };
//        Vuelo[] vuelos = {
//            new Vuelo("01", "Martes", "9", Integer.toString(9 + Integer.parseInt(rutas[0].getDuracion())), rutas[0], aviones[0], 400),
//            new Vuelo("02", "Lunes", "12", Integer.toString(12 + Integer.parseInt(rutas[1].getDuracion())), rutas[1], aviones[1], 300),
//            new Vuelo("03", "Sabado", "3", Integer.toString(3 + Integer.parseInt(rutas[2].getDuracion())), rutas[2], aviones[2], 550),
//            new Vuelo("04", "Martes", "8", Integer.toString(8 + Integer.parseInt(rutas[3].getDuracion())), rutas[3], aviones[3], 400),
//            new Vuelo("05", "Viernes", "2", Integer.toString(2 + Integer.parseInt(rutas[4].getDuracion())), rutas[4], aviones[0], 400),
//            new Vuelo("06", "Jueves", "5", Integer.toString(5 + Integer.parseInt(rutas[5].getDuracion())), rutas[5], aviones[1], 400),
//            new Vuelo("07", "Miercoles", "7", Integer.toString(7 + Integer.parseInt(rutas[6].getDuracion())), rutas[6], aviones[2], 100),
//            new Vuelo("08", "Martes", "1", Integer.toString(1 + Integer.parseInt(rutas[7].getDuracion())), rutas[7], aviones[3], 200),};
//        return new ArrayList(Arrays.asList(vuelos));
//    }
//
//    public List<Vuelo> getVuelos(String origen, String destino, String diaIda) {
//        ArrayList<Vuelo> result = new ArrayList();
//        for (Vuelo v : this.getVuelos1()) {
//            if (v.getRuta().getCiudadO().getNombre().contains(origen)
//                    && v.getRuta().getCiudadD().getNombre().contains(destino)
//                    && v.getDia_salida().contains(diaIda)) {
//                result.add(v);
//            }
//        }
//        return result;
//    }
//
//    public List<Vuelo> getVuelos1() {
//        List<Vuelo> vuelos;
//        vuelos = new ArrayList();
//        try {
//
//            String sql = "select * "
//                    + "from vuelo  c  ";
//            ResultSet rs = BD.executeQuery(sql);
//            while (rs.next()) {
//                Vuelo vuelo = new Vuelo();
//                vuelo.setCodigo_Vuelo(rs.getString("codigo_vuelo"));
//                vuelo.setHora_llegada(rs.getString("hora_llegada"));
//                vuelo.setHora_salida(rs.getString("hora_salida"));
//                vuelo.setDia_salida(rs.getString("dia_salida"));
//                vuelo.setPrecio(rs.getFloat("precio"));
//                String r = rs.getString("codigo_ruta");
//                char ascii = 34;
//                String sql4 = "select * from ruta r where r.codigo_ruta = '%s'";
//                sql4 = String.format(sql4, r);
//                ResultSet rs2 = BD.executeQuery(sql4);
//                Ruta ruta = new Ruta();
//                Ciudad ciudadO;
//                Ciudad ciudadD;
//                while (rs2.next()) {
//                    ruta.setCodigo_ruta(rs2.getString("codigo_ruta"));
//                    ruta.setDuracion(Integer.toString(rs2.getInt("duracion")));
//                    String c = rs2.getString("ciudad_origen");
//                    String sql2 = "select * from ciudad where codigo_ciudad = '%s'";
//                    sql2 = String.format(sql2, c);
//                    ResultSet rs3 = BD.executeQuery(sql2);
//                    while (rs3.next()) {
//                        ciudadO = toCiudad(rs3);
//                        ruta.setCiudadO(ciudadO);
//                    }
//                    c = rs2.getString("ciudad_destino");
//                    sql2 = "select * from ciudad where codigo_ciudad = '%s'";
//                    sql2 = String.format(sql2, c);
//                    rs3 = BD.executeQuery(sql2);
//                    while (rs3.next()) {
//                        ciudadD = toCiudad(rs3);
//                        ruta.setCiudadD(ciudadD);
//                    }
//                }
//                String a = rs.getString("codigo_av");
//                String sql2 = "select * from avion where codigo_avion = '%s'";
//                sql2 = String.format(sql2, a);
//                ResultSet rs3 = BD.executeQuery(sql2);
//                while (rs3.next()) {
//                    vuelo.setAvion(toAvion(rs3));
//                }
//                vuelo.setRuta(ruta);
//                vuelos.add(vuelo);
//            }
//        } catch (SQLException ex) {
//        }
//        return vuelos;
//    }
//
//    private static Avion toAvion(ResultSet rs) {
//        Avion plane = new Avion();
//        try {
//
//            plane.setCodigo_Avion(rs.getString("codigo_avion"));
//            plane.setCant_filas(rs.getInt("cant_filas"));
//            plane.setCant_Asiento_Fila(rs.getInt("cant_asiento_fila"));
//            plane.setCant_pasajeros(rs.getInt("cant_pasajeros"));
//            plane.setMarca(rs.getString("marca"));
//            plane.setModelo(rs.getString("modelo"));
//
//        } catch (SQLException ex) {
//            System.err.println(ex.getMessage());
//        }
//        return plane;
//    }
//
//    public List<Vuelo> getVuelos(String origen) {
//        ArrayList<Vuelo> result = new ArrayList();
//        for (Vuelo v : this.getVuelos1()) {
//            if (v.getRuta().getCiudadO().getCodigo_ciudad().contains(origen)) {
//                result.add(v);
//            }
//        }
//        return result;
//    }
//
//    public static Login userLogin(Login usuario) throws Exception {
//        try {
//            String sql = "select * from "
//                    + "Login  u  "
//                    + "where u.usuario = '%s' and u.contraseña='%s'";
//            sql = String.format(sql, usuario.getUsuario(), usuario.getContraseña());
//
//            ResultSet rs = BD.executeQuery(sql);
//            if (rs == null) {
//                return null;
//            }
//
//            if (rs.next()) {
//                return toUser(rs);
//            } else {
//                return null;
//            }
//        } catch (SQLException ex) {
//        }
//        return null;
//    }
//
//    private static Login toUser(ResultSet rs) throws Exception {
//        Login obj = new Login();
//        obj.setUsuario(rs.getString("usuario"));
//        obj.setContraseña(rs.getString("contraseña"));
//        obj.setTipo(rs.getString("tipo"));
//        return obj;
//    }
//
//    public static Usuario clientGet(String id) throws Exception {
//        String sql = "select * from "
//                + "Usuario  c  "
//                + "where c.usuario = '%s'";
//        sql = String.format(sql, id);
//
//        ResultSet rs = BD.executeQuery(sql);
//        if (rs.next()) {
//            return toClient(rs);
//        } else {
//            throw new Exception("Cliente no existe");
//        }
//    }
//
//    private static Usuario toClient(ResultSet rs) throws Exception {
//        Usuario obj = new Usuario();
//        obj.setUsuario(rs.getString("usuario"));
//        obj.setCedula(rs.getString("cedula"));
//        obj.setNombre(rs.getString("nombre"));
//        obj.setApellidos(rs.getString("apellidos"));
//        obj.setEmail(rs.getString("email"));
//        obj.setTelefono(rs.getString("telefono"));
//        obj.setCelular(rs.getString("celular"));
//        obj.setContraseña(rs.getString("contraseña"));
//        return obj;
//    }
//
//    public static int guardar1(Usuario us) throws Exception {
//        String sql = "insert into "
//                + "usuario (cedula,apellidos,celular,email,fecha,nombre,telefono,usuario,contraseña,direccion)"
//                + "values('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s')";
//        sql = String.format(sql, us.getCedula(), us.getApellidos(), us.getCelular(), us.getEmail(),
//                us.getFecha(), us.getNombre(), us.getTelefono(),
//                us.getUsuario(), us.getContraseña(),us.getDireccion());
//        String sql2 = "insert into " + "login (usuario,contraseña,tipo)" + "values('%s','%s','%s')";
//        sql2 = String.format(sql2, us.getUsuario(), us.getContraseña(), "1");
//        ResultSet rs = BD.executeUpdateWithKeys(sql);
//
//        if (rs != null) {
//            ResultSet rs2 = BD.executeUpdateWithKeys(sql2);
//            if (rs2 == null) {
//                return 1;
//            }
//            else{
//                return 0;
//            }
//        } else {
//            return 1;
//        }
//    }
//
//    public static int guardar2(Avion av) throws Exception {
//        String sql = "insert into " + "avion (codigo_avion,cant_asiento_fila,cant_filas,cant_pasajeros,modelo,marca)"
//                + "values('%s','%s','%s','%s','%s','%s')";
//        sql = String.format(sql, av.getCodigo_Avion(), av.getCant_Asiento_Fila(), av.getCant_filas(), av.getCant_pasajeros(),
//                av.getModelo(), av.getMarca());
//        ResultSet rs = BD.executeUpdateWithKeys(sql);
//        if (rs != null) {
//            if (rs.next()) {
//                return 0;
//            } else {
//                return 1;
//            }
//        } else {
//            return 1;
//        }
//
//    }
//
//    public static int guardar3(Ciudad ciu) throws Exception {
//        String sql = "insert into " + "ciudad (codigo_ciudad,nombre,pais)"
//                + "values('%s','%s','%s')";
//        sql = String.format(sql, ciu.getCodigo_ciudad(), ciu.getNombre(), ciu.getPais());
//        ResultSet rs = BD.executeUpdateWithKeys(sql);
//        if (rs != null) {
//            if (rs.next()) {
//                return 0;
//            } else {
//                return 1;
//            }
//        } else {
//            return 1;
//        }
//    }
//
//    public static int guardar4(Ruta ru) throws Exception {
//        String sql = "insert into " + "ruta (codigo_ruta,ciudad_origen,ciudad_destino,duracion)"
//                + "values('%s','%s','%s','%s')";
//        if (ru.getCiudadO() != null) {
//            sql = String.format(sql, ru.getCodigo_ruta(), ru.getCiudadO().getCodigo_ciudad(), ru.getCiudadD().getCodigo_ciudad(), ru.getDuracion());
//            ResultSet rs = BD.executeUpdateWithKeys(sql);
//            if (rs != null) {
//                if (rs.next()) {
//                    return 0;
//                } else {
//                    return 1;
//                }
//            } else {
//                return 1;
//            }
//        }
//        return 1;
//    }
//
//    public static int guardar5(Vuelo vu) throws Exception {
//        String sql = "insert into " + "vuelo (codigo_vuelo,codigo_ruta,codigo_av,dia_salida,hora_llegada,hora_salida,precio)"
//                + "values('%s','%s','%s','%s','%s','%s','%s')";
//        sql = String.format(sql, vu.getCodigo_Vuelo(), vu.getRuta().getCodigo_ruta(), vu.getAvion().getCodigo_Avion(), vu.getDia_salida(), vu.getHora_llegada(), vu.getHora_salida(), vu.getPrecio());
//        ResultSet rs = BD.executeUpdateWithKeys(sql);
//        if (rs != null) {
//            if (rs.next()) {
//                return 0;
//            } else {
//                return 1;
//            }
//        } else {
//            return 1;
//        }
//    }
//
//    public static List<Avion> getAviones() {
//        List<Avion> aviones;
//        aviones = new ArrayList();
//        try {
//            String sql = "select * "
//                    + "from avion  c  ";
//            ResultSet rs = BD.executeQuery(sql);
//            while (rs.next()) {
//                aviones.add(toAvion(rs));
//            }
//        } catch (SQLException ex) {
//        }
//        return aviones;
//    }
//
//    private static Ruta toRuta(ResultSet rs) throws Exception {
//        Ruta obj = new Ruta();
//        String sql2 = "select *" + "from ciudad c where codigo_ciudad= '%s'";
//        sql2 = String.format(sql2, rs.getString("ciudad_origen"));
//        ResultSet rs2 = BD.executeQuery(sql2);
//        while (rs2.next()) {
//            obj.setCiudadO(toCiudad(rs2));
//        }
//        String sql4 = "select *" + "from ciudad c where codigo_ciudad= '%s'";
//        sql4 = String.format(sql4, rs.getString("ciudad_destino"));
//        ResultSet rs3 = BD.executeQuery(sql4);
//        while (rs3.next()) {
//            obj.setCiudadD(toCiudad(rs3));
//        }
//        obj.setCodigo_ruta(rs.getString("codigo_ruta"));
//        obj.setDuracion(String.valueOf(rs.getInt("duracion")));
//
//        return obj;
//    }
//
//    public static List<Ruta> getRutas() throws Exception {
//        List<Ruta> rutas;
//        rutas = new ArrayList();
//        try {
//            String sql = "select * "
//                    + "from ruta  c  ";
//            ResultSet rs = BD.executeQuery(sql);
//            while (rs.next()) {
//                rutas.add(toRuta(rs));
//            }
//        } catch (SQLException ex) {
//        }
//        return rutas;
//    }
//
//    public static List<Ciudad> getCiudad(String codigo) {
//        List<Ciudad> ciudades;
//        ciudades = new ArrayList();
//        try {
//            String sql = "select * "
//                    + "from ciudad  c where codigo_ciudad= '%s' ";
//            sql = String.format(sql, codigo);
//            ResultSet rs = BD.executeQuery(sql);
//            while (rs.next()) {
//                ciudades.add(toCiudad(rs));
//            }
//        } catch (SQLException ex) {
//        }
//        return ciudades;
//    }
//
//    public static List<Ruta> getRuta(String codigo) throws Exception {
//        List<Ruta> rutas;
//        rutas = new ArrayList();
//        try {
//            String sql = "select * "
//                    + "from ruta  c where codigo_ruta= '%s'";
//            sql = String.format(sql, codigo);
//            ResultSet rs = BD.executeQuery(sql);
//            while (rs.next()) {
//                rutas.add(toRuta(rs));
//            }
//
//        } catch (SQLException ex) {
//        }
//        return rutas;
//    }
//
//    public static List<Avion> getAvion(String codigo) throws Exception {
//        List<Avion> aviones;
//        aviones = new ArrayList();
//        try {
//            String sql = "select * "
//                    + "from avion  c where codigo_avion= '%s'";
//            sql = String.format(sql, codigo);
//            ResultSet rs = BD.executeQuery(sql);
//            while (rs.next()) {
//                aviones.add(toAvion(rs));
//            }
//
//        } catch (SQLException ex) {
//        }
//        return aviones;
//    }
//    /* ******************************************************************************************************** */
//
//    /* ******************************* CAMBIOS HECHOS POR ANDRES CASCANTE SALAS ******************************* */
//
//    /* ******************************************************************************************************** */
//                    
//    public static int updateCliente(Usuario us) throws Exception{
//        String sql = "update usuario set"
//                + " cedula='%s',apellidos='%s',celular='%s',email='%s',nombre='%s',telefono='%s',contraseña='%s'"
//                + " where cedula = '%s'";
//        sql = String.format(sql, us.getCedula(), us.getApellidos(), us.getCelular(), us.getEmail(),
//                us.getNombre(), us.getTelefono(), us.getContraseña(),us.getCedula());
//        
//        String sql2 = "update usuario set" + " contraseña='%s'" + " where usuario = '%s'";
//        sql2 = String.format(sql2, us.getContraseña(), us.getCedula());
//        
//        ResultSet rs = BD.executeUpdateWithKeys(sql);
//
//        if (rs != null) {
//            ResultSet rs2 = BD.executeUpdateWithKeys(sql2);
//            if (rs2 == null) {
//                return 1;
//            }
//            else{
//                return 0;
//            }
//        } else {
//            return 1;
//        }
//    }
//    
//    public static int updateAdminis(Usuario us) throws Exception{
//        String sql = "update usuario set cedula='%s',apellidos='%s',celular='%s',email='%s',nombre='%s',telefono='%s',contraseña='%s'"
//                + "where cedula = '%s'";
//        sql = String.format(sql, us.getCedula(), us.getApellidos(), us.getCelular(), us.getEmail(),
//                us.getNombre(), us.getTelefono(), us.getContraseña(),us.getCedula());
//        
//        String sql2 = "update login set contraseña='%s' " + "where usuario = '%s'";
//        sql2 = String.format(sql2, us.getContraseña(), us.getCedula());
//        
//        int rs = BD.executeUpdate(sql);
//
//        if (rs != 0) {
//            int rs2 = BD.executeUpdate(sql2);
//            if (rs2 == 0) {
//                return 1;
//            }
//            else
//                return 0;
//        } else {
//            return 1;
//        }
//    }
//    /* ******************************************************************************************************** */
//    /* ******************************************************************************************************** */
//    /* ******************************************************************************************************** */
//    
}
