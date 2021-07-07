package es.dev.center.prueba.service.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.dev.center.prueba.dao.CocheDAO;
import es.dev.center.prueba.model.Coche;
import es.dev.center.prueba.service.CocheService;

@Service
public class CocheServiceImpl implements CocheService{

	@Autowired
	private CocheDAO cocheDAO;
	
	@Override
	public Iterable<Coche> findAll() {
		return cocheDAO. findAll();
	}

	@Override
	public Optional<Coche> findById(Long idCoche) {
		return cocheDAO.findById(idCoche);
	}

	@Override
	public ByteArrayInputStream exportData() {
		String [] columns = {"ID", "ID_MARCA", "NOMBRE_MODELO", "COLOR"};
		
		Workbook workbook = new HSSFWorkbook();
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		
		Sheet sheet = workbook.createSheet("Coches");
	    sheet.setColumnWidth(0,5000);
	    sheet.setColumnWidth(1,5000);
	    sheet.setColumnWidth(2,5000);
	    sheet.setColumnWidth(3,5000);

		Row row = sheet.createRow(0);
		
		CellStyle style = workbook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		for(int i = 0; i < columns.length; i++) {
			Cell cell = row.createCell(i);
			cell.setCellValue(columns[i]);
			cell.setCellStyle(style);
		}
		
		List<Coche> coches = new ArrayList<>();
		this.findAll().iterator().forEachRemaining(coches::add);
		
		int initRow = 1;
		for (Coche coche : coches) {
			row = sheet.createRow(initRow);
			row.createCell(0).setCellValue(coche.getId());
			row.createCell(1).setCellValue(coche.getMarca().getId());
			row.createCell(2).setCellValue(coche.getNombreModelo());
			row.createCell(3).setCellValue(coche.getColor());
			
			initRow++;
		}
		
		try {
			workbook.write(stream);
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return new ByteArrayInputStream(stream.toByteArray());
	}
	
}
