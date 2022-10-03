package com.project.SIAP.service.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.SIAP.commons.JasperReportManager;
import com.project.SIAP.enums.TipoReporteEnum;
import com.project.SIAP.model.ReporteJasperDTO;
import com.project.SIAP.service.api.ReporteJasperServiceAPI;

import net.sf.jasperreports.engine.JRException;

@Service
public class ReporteBibliotecaEstudianteServiceImpl implements ReporteJasperServiceAPI {

	@Autowired
	private JasperReportManager reportManager;

	@Autowired
	private DataSource dataSource;

	@Override
	public ReporteJasperDTO obtenerReporteEstudiantesBiblioteca(Map<String, Object> params)
			throws JRException, IOException, SQLException {
		String fileName = "reporte_ingreso_biblioteca_estudiante";
		ReporteJasperDTO dto = new ReporteJasperDTO();
		String extension = params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name()) ? ".xlsx"
				: ".pdf";
		dto.setFileName(fileName + extension);

		ByteArrayOutputStream stream = reportManager.export(fileName, params.get("tipo").toString(), params,
				dataSource.getConnection());

		byte[] bs = stream.toByteArray();
		dto.setStream(new ByteArrayInputStream(bs));
		dto.setLength(bs.length);

		return dto;
	}

	@Override
	public ReporteJasperDTO obtenerReporteDocentesBiblioteca(Map<String, Object> params)
			throws JRException, IOException, SQLException {
		String fileName = "docente_biblioteca";
		ReporteJasperDTO dto = new ReporteJasperDTO();
		String extension = params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name()) ? ".xlsx"
				: ".pdf";
		dto.setFileName(fileName + extension);

		ByteArrayOutputStream stream = reportManager.export(fileName, params.get("tipo").toString(), params,
				dataSource.getConnection());

		byte[] bs = stream.toByteArray();
		dto.setStream(new ByteArrayInputStream(bs));
		dto.setLength(bs.length);

		return dto;
	}

	@Override
	public ReporteJasperDTO obtenerReporteEstudianteCampus(Map<String, Object> params)
			throws JRException, IOException, SQLException {
		String fileName = "Estudiante_Ingreso";
		ReporteJasperDTO dto = new ReporteJasperDTO();
		String extension = params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name()) ? ".xlsx"
				: ".pdf";
		dto.setFileName(fileName + extension);

		ByteArrayOutputStream stream = reportManager.export(fileName, params.get("tipo").toString(), params,
				dataSource.getConnection());

		byte[] bs = stream.toByteArray();
		dto.setStream(new ByteArrayInputStream(bs));
		dto.setLength(bs.length);

		return dto;
	}

	@Override
	public ReporteJasperDTO obtenerReporteDocenteCampus(Map<String, Object> params)
			throws JRException, IOException, SQLException {
		String fileName = "Docente_Ingreso_Campus";
		ReporteJasperDTO dto = new ReporteJasperDTO();
		String extension = params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name()) ? ".xlsx"
				: ".pdf";
		dto.setFileName(fileName + extension);

		ByteArrayOutputStream stream = reportManager.export(fileName, params.get("tipo").toString(), params,
				dataSource.getConnection());

		byte[] bs = stream.toByteArray();
		dto.setStream(new ByteArrayInputStream(bs));
		dto.setLength(bs.length);

		return dto;
	}


	@Override
	public ReporteJasperDTO obtenerReporteEgresadoCampus(Map<String, Object> params)
			throws JRException, IOException, SQLException {
		String fileName = "egresados_campus";
		ReporteJasperDTO dto = new ReporteJasperDTO();
		String extension = params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name()) ? ".xlsx"
				: ".pdf";
		dto.setFileName(fileName + extension);

		ByteArrayOutputStream stream = reportManager.export(fileName, params.get("tipo").toString(), params,
				dataSource.getConnection());

		byte[] bs = stream.toByteArray();
		dto.setStream(new ByteArrayInputStream(bs));
		dto.setLength(bs.length);

		return dto;
	}
}

