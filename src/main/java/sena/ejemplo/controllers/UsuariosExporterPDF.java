package sena.ejemplo.controllers;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import sena.ejemplo.model.Usuario;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UsuariosExporterPDF {

    private static final BaseColor COLOR_CABECERA = new BaseColor(57, 218, 123);
    private static final BaseColor COLOR_TITULO = new BaseColor(57, 218, 123);
    private static final Font FUENTE_TITULO = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, COLOR_TITULO);

    private List<Usuario> listaUsuarios;

    public UsuariosExporterPDF(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    private PdfPCell crearCelda(String contenido, Font fuente, BaseColor colorFondo) {
        PdfPCell celda = new PdfPCell(new Phrase(contenido, fuente));
        celda.setBackgroundColor(colorFondo);
        celda.setPadding(5);
        return celda;
    }

    private void escribirCabecera(PdfPTable tabla) {
        Font fuenteCabecera = FontFactory.getFont(FontFactory.HELVETICA);
        PdfPCell celda = crearCelda("Documento", fuenteCabecera, COLOR_CABECERA);
        tabla.addCell(celda);

        celda = crearCelda("Nombre", fuenteCabecera, COLOR_CABECERA);
        tabla.addCell(celda);

        celda = crearCelda("Apellido", fuenteCabecera, COLOR_CABECERA);
        tabla.addCell(celda);

        celda = crearCelda("Telefono", fuenteCabecera, COLOR_CABECERA);
        tabla.addCell(celda);

        celda = crearCelda("Estado", fuenteCabecera, COLOR_CABECERA);
        tabla.addCell(celda);

        celda = crearCelda("Proveniente", fuenteCabecera, COLOR_CABECERA);
        tabla.addCell(celda);

        celda = crearCelda("Rol", fuenteCabecera, COLOR_CABECERA);
        tabla.addCell(celda);
    }

    private void escribirDatosTabla(PdfPTable tabla) {
        Font fuenteDatos = FontFactory.getFont(FontFactory.HELVETICA);
        for (Usuario usuario : listaUsuarios) {
            tabla.addCell(crearCelda(usuario.getDocumento(), fuenteDatos, new BaseColor(162, 255, 200)));
            tabla.addCell(crearCelda(usuario.getNombre(), fuenteDatos, BaseColor.WHITE));
            tabla.addCell(crearCelda(usuario.getApellido(), fuenteDatos, BaseColor.WHITE));
            tabla.addCell(crearCelda(usuario.getTelefono(), fuenteDatos, BaseColor.WHITE));
            tabla.addCell(crearCelda(String.valueOf(usuario.isEstado()), fuenteDatos, BaseColor.WHITE));
            tabla.addCell(crearCelda(usuario.getProveniente(), fuenteDatos, BaseColor.WHITE));
            tabla.addCell(crearCelda(usuario.getRol().getNombre(), fuenteDatos, BaseColor.WHITE));
        }
    }

    public void exportar(HttpServletResponse response, String regional, String centroGestion) throws IOException, DocumentException {
        Document documento = new Document(PageSize.A4);
        PdfWriter.getInstance(documento, response.getOutputStream());
        documento.open();

        // Add the specified information
        Paragraph regionalInfo = new Paragraph(regional);
        regionalInfo.setAlignment(Paragraph.ALIGN_LEFT);
        documento.add(regionalInfo);

        Paragraph centroGestionInfo = new Paragraph(centroGestion);
        centroGestionInfo.setAlignment(Paragraph.ALIGN_LEFT);
        documento.add(centroGestionInfo);

        // Add the title
        Paragraph titulo = new Paragraph("Lista de usuarios", FUENTE_TITULO);
        titulo.setAlignment(Paragraph.ALIGN_CENTER);
        documento.add(titulo);

        PdfPTable tabla = new PdfPTable(7);
        tabla.setWidthPercentage(100);
        tabla.setSpacingBefore(15);
        tabla.setWidths(new float[]{3f, 2.3f, 2.3f, 3f, 2.3f, 6f, 3f});
        tabla.setWidthPercentage(110);

        escribirCabecera(tabla);
        escribirDatosTabla(tabla);

        documento.add(tabla);
        documento.close();
    }
}
