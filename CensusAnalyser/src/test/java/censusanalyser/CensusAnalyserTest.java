package censusanalyser;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CensusAnalyserTest {

    private static final String INDIA_CENSUS_CSV_FILE_PATH = "./src/test/resources/IndiaStateCensusData.csv";
    private static final String WRONG_CSV_FILE_PATH = "./src/main/resources/IndiaStateCensusData.csv";
    private static final String INCORRECT_FILE_FORMAT ="./src/test/resources/IndiaStateCensusData.csv" ;
    private static final String CSV_WITH_WRONG_DELIMITER ="./src/test/resources/IndiaStateCensusData.csv";
    private static final String CSV_WITH_INCORRECT_HEADER ="./src/test/resources/IndiaStateCensusData.csv";

    @Test
    public void givenIndianCensusCSVFileReturnsCorrectRecords() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_PATH);
            Assert.assertEquals(29,numOfRecords);
        } catch (CensusAnalyserException e) { }
    }

    @Test
    public void givenIndiaCensusData_WithWrongFile_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(WRONG_CSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM,e.type);
        }
    }

    @Test
    public void givenIndianCensusCSVFile_WhenCorrectPathButWrongFileFormat_ShouldThrowException() {

        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(INCORRECT_FILE_FORMAT);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_INCORRECT_FILE_FORMAT, e.type);
        }
    }
            @Test
            public void givenIndianCensusCSVFile_WhenCustomDelimiter_ShouldThrowException() {

                try {
                    CensusAnalyser censusAnalyser = new CensusAnalyser();
                    ExpectedException exceptionRule = ExpectedException.none();
                    exceptionRule.expect(CensusAnalyserException.class);
                    censusAnalyser.loadIndiaCensusData(CSV_WITH_WRONG_DELIMITER);
                }
                catch (CensusAnalyserException e) {
                    Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_WRONG_DELIMITER_OR_WRONG_HEADER, e.type);
                }
            }
                    @Test
                    public void givenIndianCensusCSVFile_WhenIncorrectHeader_ShouldThrowException() {

                        try {
                            CensusAnalyser censusAnalyser = new CensusAnalyser();
                            ExpectedException exceptionRule = ExpectedException.none();
                            exceptionRule.expect(CensusAnalyserException.class);
                            censusAnalyser.loadIndiaCensusData(CSV_WITH_INCORRECT_HEADER);
                        }
                        catch (CensusAnalyserException e) {
                            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_WRONG_DELIMITER_OR_WRONG_HEADER, e.type);
                        }
    }

}

