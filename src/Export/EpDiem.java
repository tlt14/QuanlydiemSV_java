package Export;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import BLL.DiemBLL;
import DTO.Diem;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
//import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class EpDiem {
    private static CellStyle cellStyleFormatNumber = null;

//    public static void exMarkWithClass(ArrayList<Diem> diems, String excelFilePath){
//        try {
//            writeExcel(diems,excelFilePath);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    public static void writeExcel(ArrayList<Diem> diems, String excelFilePath) throws IOException {
        // Create Workbook
        Workbook workbook = getWorkbook(excelFilePath);

        // Create sheet
        Sheet sheet = workbook.createSheet("danhsach"); // Create sheet with sheet name

        int rowIndex = 0;

        // Write header
        writeHeader(sheet, rowIndex);

        // Write data
        rowIndex++;
        for (Diem d : diems) {
            // Create row
            Row row = sheet.createRow(rowIndex);
            // Write data on row
            writeBook(d, row);
            rowIndex++;
        }

        // Write footer
        writeFooter(sheet, rowIndex);

        // Auto resize column witdth
        int numberOfColumn = sheet.getRow(0).getPhysicalNumberOfCells();
        autosizeColumn(sheet, numberOfColumn);

        // Create file excel
        createOutputFile(workbook, excelFilePath);
//        System.out.println("Done!!!");
    }



    // Create workbook
    private static Workbook getWorkbook(String excelFilePath) throws IOException {
        Workbook workbook = null;

        if (excelFilePath.endsWith("xlsx")) {
            workbook = new XSSFWorkbook();
        } else if (excelFilePath.endsWith("xls")) {
            workbook = new HSSFWorkbook();
        } else {
            throw new IllegalArgumentException("The specified file is not Excel file");
        }

        return workbook;
    }

    // Write header with format
    private static void writeHeader(Sheet sheet, int rowIndex) {
        // create CellStyle
        CellStyle cellStyle = createStyleForHeader(sheet);

        // Create row
        Row row = sheet.createRow(rowIndex);

        // Create cells
        Cell cell = row.createCell(0);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Mã Sinh Viên");

        cell = row.createCell(1);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Họ và Tên ");

        cell = row.createCell(2);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Mã Môn ");

        cell = row.createCell(3);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Lần Thi");

        cell = row.createCell(4);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Hệ số");

        cell = row.createCell(5);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Điểm");

        cell = row.createCell(6);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Trạng thái");

    }

    // Write data
    private static void writeBook(Diem d, Row row) {
        if (cellStyleFormatNumber == null) {
            // Format number
            short format = (short)BuiltinFormats.getBuiltinFormat("#,##0");
//             DataFormat df = workbook.createDataFormat();
//             short format = df.getFormat("#,##0");

            //Create CellStyle
            Workbook workbook = row.getSheet().getWorkbook();
            cellStyleFormatNumber = workbook.createCellStyle();
            cellStyleFormatNumber.setDataFormat(format);
        }

        Cell cell = row.createCell(0);
        cell.setCellValue(d.getMaSV());

        cell = row.createCell(1);
        cell.setCellValue(d.getTenSV());

        cell = row.createCell(2);
        cell.setCellValue(d.getMaMH());

        cell = row.createCell(3);
        cell.setCellValue(d.getLanThi());
        cell.setCellStyle(cellStyleFormatNumber);

        cell = row.createCell(4);
        cell.setCellValue(d.getHeso());


        cell = row.createCell(5);
        cell.setCellValue(d.getDiem());

        cell = row.createCell(6);
        cell.setCellValue(d.isTrangThai());



    }

    // Create CellStyle for header
    private static CellStyle createStyleForHeader(Sheet sheet) {
        // Create font
        Font font = sheet.getWorkbook().createFont();
        font.setFontName("Times New Roman");
//        font.setBold(true);
        font.setFontHeightInPoints((short) 14); // font size
        font.setColor(IndexedColors.WHITE.getIndex()); // text color

        // Create CellStyle
        CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
        cellStyle.setFont(font);
        cellStyle.setFillForegroundColor(IndexedColors.BLUE.getIndex());
//        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//        cellStyle.setBorderBottom(BorderStyle.THIN);
        return cellStyle;
    }

    // Write footer
    private static void writeFooter(Sheet sheet, int rowIndex) {
        // Create row
        Row row = sheet.createRow(rowIndex);
        Cell cell = row.createCell(5);
        cell.setCellFormula("Average(F2:F"+rowIndex+")");
        cell=row.createCell(4);
        cell.setCellValue("Điểm trung bình");

    }

    // Auto resize column width
    private static void autosizeColumn(Sheet sheet, int lastColumn) {
        for (int columnIndex = 0; columnIndex < lastColumn; columnIndex++) {
            sheet.autoSizeColumn(columnIndex);
        }
    }

    // Create output file
    private static void createOutputFile(Workbook workbook, String excelFilePath) throws IOException {
        try (OutputStream os = new FileOutputStream(excelFilePath)) {
            workbook.write(os);
        }
    }

}