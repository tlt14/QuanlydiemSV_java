package Export;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import BLL.DiemBLL;
import DTO.Diem;
import DTO.Student;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class EpStudent {
    private static CellStyle cellStyleFormatNumber = null;


    public static void writeExcel(ArrayList<Student> s, String excelFilePath) throws IOException {
        // Create Workbook
        Workbook workbook = getWorkbook(excelFilePath);

        // Create sheet
        Sheet sheet = workbook.createSheet("danhsachsv"); // Create sheet with sheet name

        int rowIndex = 0;

        // Write header
        writeHeader(sheet, rowIndex);

        // Write data
        rowIndex++;
        for (Student d : s) {
            // Create row
            Row row = sheet.createRow(rowIndex);
            // Write data on row
            writeBook(d, row);
            rowIndex++;
        }

        // Write footer
//        writeFooter(sheet, rowIndex);

        // Auto resize column witdth
        int numberOfColumn = sheet.getRow(0).getPhysicalNumberOfCells();
        autosizeColumn(sheet, numberOfColumn);

        // Create file excel
        createOutputFile(workbook, excelFilePath);
//        System.out.println("Done!!!");
    }

    // Create dummy data
//    private static List<Diem> getBooks() {
//        List<Book> listBook = new ArrayList<>();
//        Book book;
//        for (int i = 1; i <= 5; i++) {
//            book = new Book(i, "Book " + i, i * 2, i * 1000);
//            listBook.add(book);
//        }
//        return listBook;
//    }

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
        cell.setCellValue("Họ Tên ");

        cell = row.createCell(2);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("ID Lớp");

        cell = row.createCell(3);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Hệ Đào Tạo");

        cell = row.createCell(4);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Ngày Sinh");

        cell = row.createCell(5);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Địa Chỉ");

        cell = row.createCell(6);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Giới Tính");

        cell = row.createCell(7);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Số Điện Thoại");
    }

    // Write data
    private static void writeBook(Student s, Row row) {
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
        cell.setCellValue(s.getMaSV());

        cell = row.createCell(1);
        cell.setCellValue(s.getHoten());

        cell = row.createCell(2);
        cell.setCellValue(s.getMaLop());
        cell.setCellStyle(cellStyleFormatNumber);

        cell = row.createCell(3);
        cell.setCellValue(s.getHedaotao());


        cell = row.createCell(4);
        cell.setCellValue(s.getNgaySinh());

        cell = row.createCell(5);
        cell.setCellValue(s.getDiaChi());

        cell = row.createCell(6);
        cell.setCellValue(s.isGioitinh()?"nam":"nữ");
        cell = row.createCell(7);
        cell.setCellValue(s.getSDT());

        // Create cell formula
        // totalMoney = price * quantity
//        cell = row.createCell(6, CellType.FORMULA);
//        cell.setCellStyle(cellStyleFormatNumber);
//        int currentRow = row.getRowNum() + 1;
//        String columnPrice = CellReference.convertNumToColString(COLUMN_INDEX_PRICE);
//        String columnQuantity = CellReference.convertNumToColString(COLUMN_INDEX_QUANTITY);
//        cell.setCellFormula(columnPrice + currentRow + "*" + columnQuantity + currentRow);
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
//        Row row = sheet.createRow(rowIndex);
//        Cell cell = row.createCell(4, CellType.FORMULA);
//        cell.setCellFormula("Average(E2:E"+rowIndex+")");
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