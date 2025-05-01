package com.vitalite.vitalite.utilitaire;


import com.vitalite.vitalite.entities.Pharmacie;
import com.vitalite.vitalite.model.ActeDto;
import com.vitalite.vitalite.model.FamilleActeDto;
import com.vitalite.vitalite.model.PharmacieDto;
import com.vitalite.vitalite.model.SousActeDto;

import org.apache.commons.compress.archivers.dump.DumpArchiveEntry.TYPE;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class ExcelAdherentHelper {
   
    
    public ExcelAdherentHelper() {
    }

    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

    public static boolean hasExcelFormat(MultipartFile file) {
    if (!TYPE.equals(file.getContentType())) {
      return false;
    }
      return true;
  }

  public static List<PharmacieDto> excelToPharmacie(InputStream is) {
    try {      
      Workbook workbook = new XSSFWorkbook(is);
      Sheet sheet = workbook.getSheet("Produits pharmaceutiques");
      Iterator<Row> rows = sheet.iterator();
      List<PharmacieDto> dtoList = new ArrayList<>();
      int rowNumber = 0;
      while (rows.hasNext()) {
        Row currentRow = rows.next();
        // skip header
        if (rowNumber == 0) {
          rowNumber++;
          continue;
        }
        Iterator<Cell> cellsInRow = currentRow.iterator();
        PharmacieDto dto = new PharmacieDto();
        int cellIdx = 0;
        while (cellsInRow.hasNext()) {
          Cell currentCell = cellsInRow.next();
          switch (cellIdx) {
          case 0:
            dto.setCode(currentCell.getStringCellValue());
            break;

          case 1:
            dto.setLibelle(currentCell.getStringCellValue());
            break;

            case 2:
            dto.setPharmaCode(currentCell.getStringCellValue());
            break;

          case 3:
            dto.setSousActeCode(currentCell.getStringCellValue());
            break;

          default:
            break;
          }
          cellIdx++;
        }
        dtoList.add(dto);
      }
      workbook.close();
      return dtoList;
    } catch (IOException e) {
      throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
    }
  }


    public static List<FamilleActeDto> excelToFamilleActe(InputStream is) {
        try {      
          Workbook workbook = new XSSFWorkbook(is);
          Sheet sheet = workbook.getSheet("famille-acte");
          Iterator<Row> rows = sheet.iterator();
          List<FamilleActeDto> dtoList = new ArrayList<>();
          int rowNumber = 0;
          while (rows.hasNext()) {
            Row currentRow = rows.next();
            // skip header
            if (rowNumber == 0) {
              rowNumber++;
              continue;
            }
            Iterator<Cell> cellsInRow = currentRow.iterator();
            FamilleActeDto dto = new FamilleActeDto();
            int cellIdx = 0;
            while (cellsInRow.hasNext()) {
              Cell currentCell = cellsInRow.next();
              switch (cellIdx) {
              case 0:
                dto.setCode(currentCell.getStringCellValue());
                break;
    
              case 1:
                dto.setLibelle(currentCell.getStringCellValue());
                break;
    
              default:
                break;
              }
              cellIdx++;
            }
            dtoList.add(dto);
          }
          workbook.close();
          return dtoList;
        } catch (IOException e) {
          throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
      }


      public static List<ActeDto> excelToActe(InputStream is) {
        try {      
          Workbook workbook = new XSSFWorkbook(is);
          Sheet sheet = workbook.getSheet("acte");
          Iterator<Row> rows = sheet.iterator();
          List<ActeDto> dtoList = new ArrayList<>();
          int rowNumber = 0;
          while (rows.hasNext()) {
            Row currentRow = rows.next();
            // skip header
            if (rowNumber == 0) {
              rowNumber++;
              continue;
            }
            Iterator<Cell> cellsInRow = currentRow.iterator();
            ActeDto dto = new ActeDto();
            int cellIdx = 0;
            while (cellsInRow.hasNext()) {
              Cell currentCell = cellsInRow.next();
              switch (cellIdx) {
              case 0:
                dto.setCode(currentCell.getStringCellValue());
                break;
    
              case 1:
                dto.setLibelle(currentCell.getStringCellValue());
                break;

                case 2:
                dto.setFamilleActeCode(currentCell.getStringCellValue());
                break;

                case 3:
                if(dto.getIsExamen() == Boolean.FALSE) {
                    dto.setIsExamen(Boolean.FALSE);
                } else {
                    dto.setIsExamen(Boolean.TRUE);
                }
                break;
    
              default:
                break;
              }
              cellIdx++;
            }
            dtoList.add(dto);
          }
          workbook.close();
          return dtoList;
        } catch (IOException e) {
          throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
      }


      public static List<SousActeDto> excelToSousActe(InputStream is) {
        try {      
          Workbook workbook = new XSSFWorkbook(is);
          Sheet sheet = workbook.getSheet("sousActe");
          Iterator<Row> rows = sheet.iterator();
          List<SousActeDto> dtoList = new ArrayList<>();
          int rowNumber = 0;
          while (rows.hasNext()) {
            Row currentRow = rows.next();
            // skip header
            if (rowNumber == 0) {
              rowNumber++;
              continue;
            }
            Iterator<Cell> cellsInRow = currentRow.iterator();
            SousActeDto dto = new SousActeDto();
            int cellIdx = 0;
            while (cellsInRow.hasNext()) {
              Cell currentCell = cellsInRow.next();
              switch (cellIdx) {
              case 0:
                dto.setCode(currentCell.getStringCellValue());
                break;
    
              case 1:
                dto.setLibelle(currentCell.getStringCellValue());
                break;

                case 2:
                dto.setActeCode(currentCell.getStringCellValue());
                break;
    
              default:
                break;
              }
              cellIdx++;
            }
            dtoList.add(dto);
          }
          workbook.close();
          return dtoList;
        } catch (IOException e) {
          throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
      }
}
