# deploy-excel
List<FundStatisticsDTO> dtos = (List<FundStatisticsDTO>) result.getData();
HSSFWorkbook workbook = ExcelAnnotationProcessor.createHssfWorkbook(dtos,FundStatisticsDTO.class);
String fileName = "xxx.xls";
response.setContentType("application/vnd.ms-excel");
response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8") + ";filename*=UTF-8''" + URLEncoder.encode(fileName, "UTF-8"));
outputStream = response.getOutputStream();
workbook.write(outputStream);
