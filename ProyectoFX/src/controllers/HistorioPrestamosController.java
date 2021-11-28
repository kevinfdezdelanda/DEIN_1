package controllers;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import dao.GestionHistorioPrestamos;
import dao.GestionLibros;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Alumno;
import model.HistorioPrestamos;
import model.Libro;
import model.Prestamo;
import javafx.scene.control.DatePicker;

import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;

public class HistorioPrestamosController implements Initializable{
	@FXML
	private TextField filtroAlumno;
	@FXML
	private TextField filtroLibro;
	@FXML
	private DatePicker filtroFDevolucion;
	@FXML
	private DatePicker filtroFPrestamo;
	@FXML
	private TableView<HistorioPrestamos> tableHistorioPrestamos;
	@FXML
	private TableColumn<HistorioPrestamos, Alumno> colAlumno;
	@FXML
	private TableColumn<HistorioPrestamos, Libro> colLibro;
	@FXML
	private TableColumn<HistorioPrestamos, Date> colFPrestamo;
	@FXML
	private TableColumn<HistorioPrestamos, Date> colFDevolucion;
	
	private ObservableList<HistorioPrestamos> hPrestamos;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		hPrestamos = FXCollections.observableArrayList();
		tableHistorioPrestamos.setItems(hPrestamos);
		colAlumno.setCellValueFactory(new PropertyValueFactory<HistorioPrestamos, Alumno>("alumno"));
		colLibro.setCellValueFactory(new PropertyValueFactory<HistorioPrestamos, Libro>("libro"));
		colFDevolucion.setCellValueFactory(new PropertyValueFactory<HistorioPrestamos, Date>("fechaDevolucion"));
		colFPrestamo.setCellValueFactory(new PropertyValueFactory<HistorioPrestamos, Date>("fechaPrestamo"));
		
		FilteredList<HistorioPrestamos> filteredData = new FilteredList<>(hPrestamos, p -> true);
		
		filtroLibro.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(prestamo -> {
				// If filter text is empty, display all persons.
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (prestamo.getLibro().getTitulo().toLowerCase().contains(lowerCaseFilter)) {
					return true; // Filter matches first name.
				}
				return false; // Does not match.
			});
		});
		
		filtroAlumno.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(prestamo -> {
				// If filter text is empty, display all persons.
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (prestamo.getAlumno().getNombre().toLowerCase().contains(lowerCaseFilter) || 
						prestamo.getAlumno().getApellido1().toLowerCase().contains(lowerCaseFilter) || 
						prestamo.getAlumno().getApellido2().toLowerCase().contains(lowerCaseFilter)) {
					return true; // Filter matches first name.
				}
				return false; // Does not match.
			});
		});
		
		filtroFDevolucion.valueProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(prestamo -> {
				// If filter text is empty, display all persons.
				if (newValue == null ) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				LocalDate newDate = newValue;
				LocalDate oldDate = prestamo.getFechaDevolucion().toLocalDate() ;
				
				if (newDate.isBefore(oldDate) || newDate.isEqual(oldDate)) {
					return true; // Filter matches first name.
				}
				return false; // Does not match.
			});
		});
		
		filtroFPrestamo.valueProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(prestamo -> {
				// If filter text is empty, display all persons.
				if (newValue == null) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				LocalDate newDate = newValue;
				LocalDate oldDate = prestamo.getFechaPrestamo().toLocalDate() ;
				
				if (newDate.isAfter(oldDate) || newDate.isEqual(oldDate)) {
					return true; // Filter matches first name.
				}
				return false; // Does not match.
			});
		});
		
				
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<HistorioPrestamos> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		sortedData.comparatorProperty().bind(tableHistorioPrestamos.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		tableHistorioPrestamos.setItems(sortedData);
		
		cargarHistorioPrestamos();
	}
	
	
	public void cargarHistorioPrestamos() {
		GestionHistorioPrestamos gh = new GestionHistorioPrestamos();
		
		ArrayList<HistorioPrestamos> h = gh.getHistorioPrestamos();
		
		hPrestamos.clear();
		hPrestamos.addAll(h);
	}
	
}
