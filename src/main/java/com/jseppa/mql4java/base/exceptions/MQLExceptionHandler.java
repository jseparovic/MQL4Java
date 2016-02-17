package com.jseppa.mql4java.base.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;

/**
 * Created by Jason on 2/14/2016.
 */
public class MQLExceptionHandler extends Exception
{
    public Logger LOG = LoggerFactory.getLogger(getClass());

    private MQLExceptionHandler()
    {
    }

    private static MQLExceptionHandler mqlExceptionHandler;

    public static MQLExceptionHandler getInstance()
    {
        if(mqlExceptionHandler == null)
        {
            mqlExceptionHandler = new MQLExceptionHandler();
        }
        return mqlExceptionHandler;
    }

    public String convertRESTException(String message)
    {
        return message;
    }

    public void throwMQLException(int error, String functionCall) throws MQLException
    {
        LOG.debug(MessageFormat.format("throwMQLException({0},{1})", error, functionCall));

        if (error == 1)
        {
            throw new NoResultException(functionCall);
        }
        else if (error == 2)
        {
            throw new CommonErrorException(functionCall);
        }
        else if (error == 3)
        {
            throw new InvalidTradeParametersException(functionCall);
        }
        else if (error == 4)
        {
            throw new ServerBusyException(functionCall);
        }
        else if (error == 5)
        {
            throw new OldVersionException(functionCall);
        }
        else if (error == 6)
        {
            throw new NoConnectionException(functionCall);
        }
        else if (error == 7)
        {
            throw new NotEnoughRightsException(functionCall);
        }
        else if (error == 8)
        {
            throw new TooFrequentRequestsException(functionCall);
        }
        else if (error == 9)
        {
            throw new MalfunctionalTradeException(functionCall);
        }
        else if (error == 64)
        {
            throw new AccountDisabledException(functionCall);
        }
        else if (error == 65)
        {
            throw new InvalidAccountException(functionCall);
        }
        else if (error == 128)
        {
            throw new TradeTimeoutException(functionCall);
        }
        else if (error == 129)
        {
            throw new InvalidPriceException(functionCall);
        }
        else if (error == 130)
        {
            throw new InvalidStopsException(functionCall);
        }
        else if (error == 131)
        {
            throw new InvalidTradeVolumeException(functionCall);
        }
        else if (error == 132)
        {
            throw new MarketClosedException(functionCall);
        }
        else if (error == 133)
        {
            throw new TradeDisabledException(functionCall);
        }
        else if (error == 134)
        {
            throw new NotEnoughMoneyException(functionCall);
        }
        else if (error == 135)
        {
            throw new PriceChangedException(functionCall);
        }
        else if (error == 136)
        {
            throw new OffQuotesException(functionCall);
        }
        else if (error == 137)
        {
            throw new BrokerBusyException(functionCall);
        }
        else if (error == 138)
        {
            throw new RequoteException(functionCall);
        }
        else if (error == 139)
        {
            throw new OrderLockedException(functionCall);
        }
        else if (error == 140)
        {
            throw new LongPositionsOnlyAllowedException(functionCall);
        }
        else if (error == 141)
        {
            throw new TooManyRequestsException(functionCall);
        }
        else if (error == 145)
        {
            throw new TradeModifyDeniedException(functionCall);
        }
        else if (error == 146)
        {
            throw new TradeContextBusyException(functionCall);
        }
        else if (error == 147)
        {
            throw new TradeExpirationDeniedException(functionCall);
        }
        else if (error == 148)
        {
            throw new TradeTooManyOrdersException(functionCall);
        }
        else if (error == 149)
        {
            throw new TradeHedgeProhibitedException(functionCall);
        }
        else if (error == 150)
        {
            throw new TradeProhibitedByFifoException(functionCall);
        }
        else if (error == 4000)
        {
            throw new NoMqlerrorException(functionCall);
        }
        else if (error == 4001)
        {
            throw new WrongFunctionPointerException(functionCall);
        }
        else if (error == 4002)
        {
            throw new ArrayIndexOutOfRangeException(functionCall);
        }
        else if (error == 4003)
        {
            throw new NoMemoryForCallStackException(functionCall);
        }
        else if (error == 4004)
        {
            throw new RecursiveStackOverflowException(functionCall);
        }
        else if (error == 4005)
        {
            throw new NotEnoughStackForParamException(functionCall);
        }
        else if (error == 4006)
        {
            throw new NoMemoryForParamStringException(functionCall);
        }
        else if (error == 4007)
        {
            throw new NoMemoryForTempStringException(functionCall);
        }
        else if (error == 4008)
        {
            throw new NotInitializedStringException(functionCall);
        }
        else if (error == 4009)
        {
            throw new NotInitializedArraystringException(functionCall);
        }
        else if (error == 4010)
        {
            throw new NoMemoryForArraystringException(functionCall);
        }
        else if (error == 4011)
        {
            throw new TooLongStringException(functionCall);
        }
        else if (error == 4012)
        {
            throw new RemainderFromZeroDivideException(functionCall);
        }
        else if (error == 4013)
        {
            throw new ZeroDivideException(functionCall);
        }
        else if (error == 4014)
        {
            throw new UnknownCommandException(functionCall);
        }
        else if (error == 4015)
        {
            throw new WrongJumpException(functionCall);
        }
        else if (error == 4016)
        {
            throw new NotInitializedArrayException(functionCall);
        }
        else if (error == 4017)
        {
            throw new DllCallsNotAllowedException(functionCall);
        }
        else if (error == 4018)
        {
            throw new CannotLoadLibraryException(functionCall);
        }
        else if (error == 4019)
        {
            throw new CannotCallFunctionException(functionCall);
        }
        else if (error == 4020)
        {
            throw new ExternalCallsNotAllowedException(functionCall);
        }
        else if (error == 4021)
        {
            throw new NoMemoryForReturnedStrException(functionCall);
        }
        else if (error == 4022)
        {
            throw new SystemBusyException(functionCall);
        }
        else if (error == 4023)
        {
            throw new DllfuncCriticalerrorException(functionCall);
        }
        else if (error == 4024)
        {
            throw new InternalErrorException(functionCall);
        }
        else if (error == 4025)
        {
            throw new OutOfMemoryException(functionCall);
        }
        else if (error == 4026)
        {
            throw new InvalidPointerException(functionCall);
        }
        else if (error == 4027)
        {
            throw new FormatTooManyFormattersException(functionCall);
        }
        else if (error == 4028)
        {
            throw new FormatTooManyParametersException(functionCall);
        }
        else if (error == 4029)
        {
            throw new ArrayInvalidException(functionCall);
        }
        else if (error == 4030)
        {
            throw new ChartNoreplyException(functionCall);
        }
        else if (error == 4050)
        {
            throw new InvalidFunctionParamscntException(functionCall);
        }
        else if (error == 4051)
        {
            throw new InvalidFunctionParamvalueException(functionCall);
        }
        else if (error == 4052)
        {
            throw new StringFunctionInternalException(functionCall);
        }
        else if (error == 4053)
        {
            throw new SomeArrayErrorException(functionCall);
        }
        else if (error == 4054)
        {
            throw new IncorrectSeriesarrayUsingException(functionCall);
        }
        else if (error == 4055)
        {
            throw new CustomIndicatorErrorException(functionCall);
        }
        else if (error == 4056)
        {
            throw new IncompatibleArraysException(functionCall);
        }
        else if (error == 4057)
        {
            throw new GlobalVariablesProcessingException(functionCall);
        }
        else if (error == 4058)
        {
            throw new GlobalVariableNotFoundException(functionCall);
        }
        else if (error == 4059)
        {
            throw new FuncNotAllowedInTestingException(functionCall);
        }
        else if (error == 4060)
        {
            throw new FunctionNotConfirmedException(functionCall);
        }
        else if (error == 4061)
        {
            throw new SendMailErrorException(functionCall);
        }
        else if (error == 4062)
        {
            throw new StringParameterExpectedException(functionCall);
        }
        else if (error == 4063)
        {
            throw new IntegerParameterExpectedException(functionCall);
        }
        else if (error == 4064)
        {
            throw new DoubleParameterExpectedException(functionCall);
        }
        else if (error == 4065)
        {
            throw new ArrayAsParameterExpectedException(functionCall);
        }
        else if (error == 4066)
        {
            throw new HistoryWillUpdatedException(functionCall);
        }
        else if (error == 4067)
        {
            throw new TradeErrorException(functionCall);
        }
        else if (error == 4068)
        {
            throw new ResourceNotFoundException(functionCall);
        }
        else if (error == 4069)
        {
            throw new ResourceNotSupportedException(functionCall);
        }
        else if (error == 4070)
        {
            throw new ResourceDuplicatedException(functionCall);
        }
        else if (error == 4071)
        {
            throw new IndicatorCannotInitException(functionCall);
        }
        else if (error == 4072)
        {
            throw new IndicatorCannotLoadException(functionCall);
        }
        else if (error == 4073)
        {
            throw new NoHistoryDataException(functionCall);
        }
        else if (error == 4074)
        {
            throw new NoMemoryForHistoryException(functionCall);
        }
        else if (error == 4075)
        {
            throw new NoMemoryForIndicatorException(functionCall);
        }
        else if (error == 4099)
        {
            throw new EndOfFileException(functionCall);
        }
        else if (error == 4100)
        {
            throw new SomeFileErrorException(functionCall);
        }
        else if (error == 4101)
        {
            throw new WrongFileNameException(functionCall);
        }
        else if (error == 4102)
        {
            throw new TooManyOpenedFilesException(functionCall);
        }
        else if (error == 4103)
        {
            throw new CannotOpenFileException(functionCall);
        }
        else if (error == 4104)
        {
            throw new IncompatibleFileaccessException(functionCall);
        }
        else if (error == 4105)
        {
            throw new NoOrderSelectedException(functionCall);
        }
        else if (error == 4106)
        {
            throw new UnknownSymbolException(functionCall);
        }
        else if (error == 4107)
        {
            throw new InvalidPriceParamException(functionCall);
        }
        else if (error == 4108)
        {
            throw new InvalidTicketException(functionCall);
        }
        else if (error == 4109)
        {
            throw new TradeNotAllowedException(functionCall);
        }
        else if (error == 4110)
        {
            throw new LongsNotAllowedException(functionCall);
        }
        else if (error == 4111)
        {
            throw new ShortsNotAllowedExceptionException(functionCall);
        }
        else if (error == 4112)
        {
            throw new TradeExpertDisabledByServerException(functionCall);
        }
        else if (error == 4200)
        {
            throw new ObjectAlreadyExistsException(functionCall);
        }
        else if (error == 4201)
        {
            throw new UnknownObjectPropertyException(functionCall);
        }
        else if (error == 4202)
        {
            throw new ObjectDoesNotExistException(functionCall);
        }
        else if (error == 4203)
        {
            throw new UnknownObjectTypeException(functionCall);
        }
        else if (error == 4204)
        {
            throw new NoObjectNameException(functionCall);
        }
        else if (error == 4205)
        {
            throw new ObjectCoordinatesErrorException(functionCall);
        }
        else if (error == 4206)
        {
            throw new NoSpecifiedSubwindowException(functionCall);
        }
        else if (error == 4207)
        {
            throw new SomeObjectErrorException(functionCall);
        }
        else if (error == 4210)
        {
            throw new ChartPropInvalidException(functionCall);
        }
        else if (error == 4211)
        {
            throw new ChartNotFoundException(functionCall);
        }
        else if (error == 4212)
        {
            throw new ChartwindowNotFoundException(functionCall);
        }
        else if (error == 4213)
        {
            throw new ChartindicatorNotFoundException(functionCall);
        }
        else if (error == 4220)
        {
            throw new SymbolSelectException(functionCall);
        }
        else if (error == 4250)
        {
            throw new NotificationErrorException(functionCall);
        }
        else if (error == 4251)
        {
            throw new NotificationParameterException(functionCall);
        }
        else if (error == 4252)
        {
            throw new NotificationSettingsException(functionCall);
        }
        else if (error == 4253)
        {
            throw new NotificationTooFrequentException(functionCall);
        }
        else if (error == 4260)
        {
            throw new FtpNoserverException(functionCall);
        }
        else if (error == 4261)
        {
            throw new FtpNologinException(functionCall);
        }
        else if (error == 4262)
        {
            throw new FtpConnectFailedException(functionCall);
        }
        else if (error == 4263)
        {
            throw new FtpClosedException(functionCall);
        }
        else if (error == 4264)
        {
            throw new FtpChangedirException(functionCall);
        }
        else if (error == 4265)
        {
            throw new FtpFileErrorException(functionCall);
        }
        else if (error == 4266)
        {
            throw new FtpErrorException(functionCall);
        }
        else if (error == 5001)
        {
            throw new FileTooManyOpenedException(functionCall);
        }
        else if (error == 5002)
        {
            throw new FileWrongFilenameException(functionCall);
        }
        else if (error == 5003)
        {
            throw new FileTooLongFilenameException(functionCall);
        }
        else if (error == 5004)
        {
            throw new FileCannotOpenException(functionCall);
        }
        else if (error == 5005)
        {
            throw new FileBufferAllocationErrorException(functionCall);
        }
        else if (error == 5006)
        {
            throw new FileCannotDeleteException(functionCall);
        }
        else if (error == 5007)
        {
            throw new FileInvalidHandleException(functionCall);
        }
        else if (error == 5008)
        {
            throw new FileWrongHandleException(functionCall);
        }
        else if (error == 5009)
        {
            throw new FileNotTowriteException(functionCall);
        }
        else if (error == 5010)
        {
            throw new FileNotToreadException(functionCall);
        }
        else if (error == 5011)
        {
            throw new FileNotBinException(functionCall);
        }
        else if (error == 5012)
        {
            throw new FileNotTxtException(functionCall);
        }
        else if (error == 5013)
        {
            throw new FileNotTxtorcsvException(functionCall);
        }
        else if (error == 5014)
        {
            throw new FileNotCsvException(functionCall);
        }
        else if (error == 5015)
        {
            throw new FileReadErrorException(functionCall);
        }
        else if (error == 5016)
        {
            throw new FileWriteErrorException(functionCall);
        }
        else if (error == 5017)
        {
            throw new FileBinStringsizeException(functionCall);
        }
        else if (error == 5018)
        {
            throw new FileIncompatibleException(functionCall);
        }
        else if (error == 5019)
        {
            throw new FileIsDirectoryException(functionCall);
        }
        else if (error == 5020)
        {
            throw new FileNotExistException(functionCall);
        }
        else if (error == 5021)
        {
            throw new FileCannotRewriteException(functionCall);
        }
        else if (error == 5022)
        {
            throw new FileWrongDirectorynameException(functionCall);
        }
        else if (error == 5023)
        {
            throw new FileDirectoryNotExistException(functionCall);
        }
        else if (error == 5024)
        {
            throw new FileNotDirectoryException(functionCall);
        }
        else if (error == 5025)
        {
            throw new FileCannotDeleteDirectoryException(functionCall);
        }
        else if (error == 5026)
        {
            throw new FileCannotCleanDirectoryException(functionCall);
        }
        else if (error == 5027)
        {
            throw new FileArrayresizeErrorException(functionCall);
        }
        else if (error == 5028)
        {
            throw new FileStringresizeErrorException(functionCall);
        }
        else if (error == 5029)
        {
            throw new FileStructWithObjectsException(functionCall);
        }
        else if (error == 5200)
        {
            throw new WebrequestInvalidAddressException(functionCall);
        }
        else if (error == 5201)
        {
            throw new WebrequestConnectFailedException(functionCall);
        }
        else if (error == 5202)
        {
            throw new WebrequestTimeoutException(functionCall);
        }
        else if (error == 5203)
        {
            throw new WebrequestRequestFailedException(functionCall);
        }
        else if (error == 65536)
        {
            throw new UserErrorFirstException(functionCall);
        }
    }

    class NoResultException extends MQLException
    {
        public NoResultException(String functionCall)
        {
            super("No error returned, but the result is unknown: " + functionCall);
        }
    }

    class CommonErrorException extends MQLException
    {
        public CommonErrorException(String functionCall)
        {
            super("Common error: " + functionCall);
        }
    }

    class InvalidTradeParametersException extends MQLException
    {
        public InvalidTradeParametersException(String functionCall)
        {
            super("Invalid trade parameters: " + functionCall);
        }
    }

    class ServerBusyException extends MQLException
    {
        public ServerBusyException(String functionCall)
        {
            super("Trade server is busy: " + functionCall);
        }
    }

    class OldVersionException extends MQLException
    {
        public OldVersionException(String functionCall)
        {
            super("Old version of the client terminal: " + functionCall);
        }
    }

    class NoConnectionException extends MQLException
    {
        public NoConnectionException(String functionCall)
        {
            super("No connection with trade server: " + functionCall);
        }
    }

    class NotEnoughRightsException extends MQLException
    {
        public NotEnoughRightsException(String functionCall)
        {
            super("Not enough rights: " + functionCall);
        }
    }

    class TooFrequentRequestsException extends MQLException
    {
        public TooFrequentRequestsException(String functionCall)
        {
            super("Too frequent requests: " + functionCall);
        }
    }

    class MalfunctionalTradeException extends MQLException
    {
        public MalfunctionalTradeException(String functionCall)
        {
            super("Malfunctional trade operation: " + functionCall);
        }
    }

    class AccountDisabledException extends MQLException
    {
        public AccountDisabledException(String functionCall)
        {
            super("Account disabled: " + functionCall);
        }
    }

    class InvalidAccountException extends MQLException
    {
        public InvalidAccountException(String functionCall)
        {
            super("Invalid account: " + functionCall);
        }
    }

    class TradeTimeoutException extends MQLException
    {
        public TradeTimeoutException(String functionCall)
        {
            super("Trade timeout: " + functionCall);
        }
    }

    class InvalidPriceException extends MQLException
    {
        public InvalidPriceException(String functionCall)
        {
            super("Invalid price: " + functionCall);
        }
    }

    class InvalidStopsException extends MQLException
    {
        public InvalidStopsException(String functionCall)
        {
            super("Invalid stops: " + functionCall);
        }
    }

    class InvalidTradeVolumeException extends MQLException
    {
        public InvalidTradeVolumeException(String functionCall)
        {
            super("Invalid trade volume: " + functionCall);
        }
    }

    class MarketClosedException extends MQLException
    {
        public MarketClosedException(String functionCall)
        {
            super("Market is closed: " + functionCall);
        }
    }

    class TradeDisabledException extends MQLException
    {
        public TradeDisabledException(String functionCall)
        {
            super("Trade is disabled: " + functionCall);
        }
    }

    class NotEnoughMoneyException extends MQLException
    {
        public NotEnoughMoneyException(String functionCall)
        {
            super("Not enough money: " + functionCall);
        }
    }

    class PriceChangedException extends MQLException
    {
        public PriceChangedException(String functionCall)
        {
            super("Price changed: " + functionCall);
        }
    }

    class OffQuotesException extends MQLException
    {
        public OffQuotesException(String functionCall)
        {
            super("Off quotes: " + functionCall);
        }
    }

    class BrokerBusyException extends MQLException
    {
        public BrokerBusyException(String functionCall)
        {
            super("Broker is busy: " + functionCall);
        }
    }

    class RequoteException extends MQLException
    {
        public RequoteException(String functionCall)
        {
            super("Requote: " + functionCall);
        }
    }

    class OrderLockedException extends MQLException
    {
        public OrderLockedException(String functionCall)
        {
            super("Order is locked: " + functionCall);
        }
    }

    class LongPositionsOnlyAllowedException extends MQLException
    {
        public LongPositionsOnlyAllowedException(String functionCall)
        {
            super("Buy orders only allowed: " + functionCall);
        }
    }

    class TooManyRequestsException extends MQLException
    {
        public TooManyRequestsException(String functionCall)
        {
            super("Too many requests: " + functionCall);
        }
    }

    class TradeModifyDeniedException extends MQLException
    {
        public TradeModifyDeniedException(String functionCall)
        {
            super("Modification denied because order is too close to market: " + functionCall);
        }
    }

    class TradeContextBusyException extends MQLException
    {
        public TradeContextBusyException(String functionCall)
        {
            super("Trade context is busy: " + functionCall);
        }
    }

    class TradeExpirationDeniedException extends MQLException
    {
        public TradeExpirationDeniedException(String functionCall)
        {
            super("Expirations are denied by broker: " + functionCall);
        }
    }

    class TradeTooManyOrdersException extends MQLException
    {
        public TradeTooManyOrdersException(String functionCall)
        {
            super("The amount of open and pending orders has reached the limit set by the broker: " + functionCall);
        }
    }

    class TradeHedgeProhibitedException extends MQLException
    {
        public TradeHedgeProhibitedException(String functionCall)
        {
            super("An attempt to open an order opposite to the existing one when hedging is disabled: " + functionCall);
        }
    }

    class TradeProhibitedByFifoException extends MQLException
    {
        public TradeProhibitedByFifoException(String functionCall)
        {
            super("An attempt to close an order contravening the FIFO rule: " + functionCall);
        }
    }

    class NoMqlerrorException extends MQLException
    {
        public NoMqlerrorException(String functionCall)
        {
            super("No error returned: " + functionCall);
        }
    }

    class WrongFunctionPointerException extends MQLException
    {
        public WrongFunctionPointerException(String functionCall)
        {
            super("Wrong function pointer: " + functionCall);
        }
    }

    class ArrayIndexOutOfRangeException extends MQLException
    {
        public ArrayIndexOutOfRangeException(String functionCall)
        {
            super("Array index is out of range: " + functionCall);
        }
    }

    class NoMemoryForCallStackException extends MQLException
    {
        public NoMemoryForCallStackException(String functionCall)
        {
            super("No memory for function call stack: " + functionCall);
        }
    }

    class RecursiveStackOverflowException extends MQLException
    {
        public RecursiveStackOverflowException(String functionCall)
        {
            super("Recursive stack overflow: " + functionCall);
        }
    }

    class NotEnoughStackForParamException extends MQLException
    {
        public NotEnoughStackForParamException(String functionCall)
        {
            super("Not enough stack for parameter: " + functionCall);
        }
    }

    class NoMemoryForParamStringException extends MQLException
    {
        public NoMemoryForParamStringException(String functionCall)
        {
            super("No memory for parameter string: " + functionCall);
        }
    }

    class NoMemoryForTempStringException extends MQLException
    {
        public NoMemoryForTempStringException(String functionCall)
        {
            super("No memory for temp string: " + functionCall);
        }
    }

    class NotInitializedStringException extends MQLException
    {
        public NotInitializedStringException(String functionCall)
        {
            super("Not initialized string: " + functionCall);
        }
    }

    class NotInitializedArraystringException extends MQLException
    {
        public NotInitializedArraystringException(String functionCall)
        {
            super("Not initialized string in array: " + functionCall);
        }
    }

    class NoMemoryForArraystringException extends MQLException
    {
        public NoMemoryForArraystringException(String functionCall)
        {
            super("No memory for array string: " + functionCall);
        }
    }

    class TooLongStringException extends MQLException
    {
        public TooLongStringException(String functionCall)
        {
            super("Too long string: " + functionCall);
        }
    }

    class RemainderFromZeroDivideException extends MQLException
    {
        public RemainderFromZeroDivideException(String functionCall)
        {
            super("Remainder from zero divide: " + functionCall);
        }
    }

    class ZeroDivideException extends MQLException
    {
        public ZeroDivideException(String functionCall)
        {
            super("Zero divide: " + functionCall);
        }
    }

    class UnknownCommandException extends MQLException
    {
        public UnknownCommandException(String functionCall)
        {
            super("Unknown command: " + functionCall);
        }
    }

    class WrongJumpException extends MQLException
    {
        public WrongJumpException(String functionCall)
        {
            super("Wrong jump (never generated error): " + functionCall);
        }
    }

    class NotInitializedArrayException extends MQLException
    {
        public NotInitializedArrayException(String functionCall)
        {
            super("Not initialized array: " + functionCall);
        }
    }

    class DllCallsNotAllowedException extends MQLException
    {
        public DllCallsNotAllowedException(String functionCall)
        {
            super("DLL calls are not allowed: " + functionCall);
        }
    }

    class CannotLoadLibraryException extends MQLException
    {
        public CannotLoadLibraryException(String functionCall)
        {
            super("Cannot load library: " + functionCall);
        }
    }

    class CannotCallFunctionException extends MQLException
    {
        public CannotCallFunctionException(String functionCall)
        {
            super("Cannot call function: " + functionCall);
        }
    }

    class ExternalCallsNotAllowedException extends MQLException
    {
        public ExternalCallsNotAllowedException(String functionCall)
        {
            super("Expert function calls are not allowed: " + functionCall);
        }
    }

    class NoMemoryForReturnedStrException extends MQLException
    {
        public NoMemoryForReturnedStrException(String functionCall)
        {
            super("Not enough memory for temp string returned from function: " + functionCall);
        }
    }

    class SystemBusyException extends MQLException
    {
        public SystemBusyException(String functionCall)
        {
            super("System is busy (never generated error): " + functionCall);
        }
    }

    class DllfuncCriticalerrorException extends MQLException
    {
        public DllfuncCriticalerrorException(String functionCall)
        {
            super("DLL-function call critical error: " + functionCall);
        }
    }

    class InternalErrorException extends MQLException
    {
        public InternalErrorException(String functionCall)
        {
            super("Internal error: " + functionCall);
        }
    }

    class OutOfMemoryException extends MQLException
    {
        public OutOfMemoryException(String functionCall)
        {
            super("Out of memory: " + functionCall);
        }
    }

    class InvalidPointerException extends MQLException
    {
        public InvalidPointerException(String functionCall)
        {
            super("Invalid pointer: " + functionCall);
        }
    }

    class FormatTooManyFormattersException extends MQLException
    {
        public FormatTooManyFormattersException(String functionCall)
        {
            super("Too many formatters in the format function: " + functionCall);
        }
    }

    class FormatTooManyParametersException extends MQLException
    {
        public FormatTooManyParametersException(String functionCall)
        {
            super("Parameters count exceeds formatters count: " + functionCall);
        }
    }

    class ArrayInvalidException extends MQLException
    {
        public ArrayInvalidException(String functionCall)
        {
            super("Invalid array: " + functionCall);
        }
    }

    class ChartNoreplyException extends MQLException
    {
        public ChartNoreplyException(String functionCall)
        {
            super("No reply from chart: " + functionCall);
        }
    }

    class InvalidFunctionParamscntException extends MQLException
    {
        public InvalidFunctionParamscntException(String functionCall)
        {
            super("Invalid function parameters count: " + functionCall);
        }
    }

    class InvalidFunctionParamvalueException extends MQLException
    {
        public InvalidFunctionParamvalueException(String functionCall)
        {
            super("Invalid function parameter value: " + functionCall);
        }
    }

    class StringFunctionInternalException extends MQLException
    {
        public StringFunctionInternalException(String functionCall)
        {
            super("String function internal error: " + functionCall);
        }
    }

    class SomeArrayErrorException extends MQLException
    {
        public SomeArrayErrorException(String functionCall)
        {
            super("Some array error: " + functionCall);
        }
    }

    class IncorrectSeriesarrayUsingException extends MQLException
    {
        public IncorrectSeriesarrayUsingException(String functionCall)
        {
            super("Incorrect series array using: " + functionCall);
        }
    }

    class CustomIndicatorErrorException extends MQLException
    {
        public CustomIndicatorErrorException(String functionCall)
        {
            super("Custom indicator error: " + functionCall);
        }
    }

    class IncompatibleArraysException extends MQLException
    {
        public IncompatibleArraysException(String functionCall)
        {
            super("Arrays are incompatible: " + functionCall);
        }
    }

    class GlobalVariablesProcessingException extends MQLException
    {
        public GlobalVariablesProcessingException(String functionCall)
        {
            super("Global variables processing error: " + functionCall);
        }
    }

    class GlobalVariableNotFoundException extends MQLException
    {
        public GlobalVariableNotFoundException(String functionCall)
        {
            super("Global variable not found: " + functionCall);
        }
    }

    class FuncNotAllowedInTestingException extends MQLException
    {
        public FuncNotAllowedInTestingException(String functionCall)
        {
            super("Function is not allowed in testing mode: " + functionCall);
        }
    }

    class FunctionNotConfirmedException extends MQLException
    {
        public FunctionNotConfirmedException(String functionCall)
        {
            super("Function is not allowed for call: " + functionCall);
        }
    }

    class SendMailErrorException extends MQLException
    {
        public SendMailErrorException(String functionCall)
        {
            super("Send mail error: " + functionCall);
        }
    }

    class StringParameterExpectedException extends MQLException
    {
        public StringParameterExpectedException(String functionCall)
        {
            super("String parameter expected: " + functionCall);
        }
    }

    class IntegerParameterExpectedException extends MQLException
    {
        public IntegerParameterExpectedException(String functionCall)
        {
            super("Integer parameter expected: " + functionCall);
        }
    }

    class DoubleParameterExpectedException extends MQLException
    {
        public DoubleParameterExpectedException(String functionCall)
        {
            super("Double parameter expected: " + functionCall);
        }
    }

    class ArrayAsParameterExpectedException extends MQLException
    {
        public ArrayAsParameterExpectedException(String functionCall)
        {
            super("Array as parameter expected: " + functionCall);
        }
    }

    class HistoryWillUpdatedException extends MQLException
    {
        public HistoryWillUpdatedException(String functionCall)
        {
            super("Requested history data is in updating state: " + functionCall);
        }
    }

    class TradeErrorException extends MQLException
    {
        public TradeErrorException(String functionCall)
        {
            super("Internal trade error: " + functionCall);
        }
    }

    class ResourceNotFoundException extends MQLException
    {
        public ResourceNotFoundException(String functionCall)
        {
            super("Resource not found: " + functionCall);
        }
    }

    class ResourceNotSupportedException extends MQLException
    {
        public ResourceNotSupportedException(String functionCall)
        {
            super("Resource not supported: " + functionCall);
        }
    }

    class ResourceDuplicatedException extends MQLException
    {
        public ResourceDuplicatedException(String functionCall)
        {
            super("Duplicate resource: " + functionCall);
        }
    }

    class IndicatorCannotInitException extends MQLException
    {
        public IndicatorCannotInitException(String functionCall)
        {
            super("Custom indicator cannot initialize: " + functionCall);
        }
    }

    class IndicatorCannotLoadException extends MQLException
    {
        public IndicatorCannotLoadException(String functionCall)
        {
            super("Cannot load custom indicator: " + functionCall);
        }
    }

    class NoHistoryDataException extends MQLException
    {
        public NoHistoryDataException(String functionCall)
        {
            super("No history data: " + functionCall);
        }
    }

    class NoMemoryForHistoryException extends MQLException
    {
        public NoMemoryForHistoryException(String functionCall)
        {
            super("No memory for history data: " + functionCall);
        }
    }

    class NoMemoryForIndicatorException extends MQLException
    {
        public NoMemoryForIndicatorException(String functionCall)
        {
            super("Not enough memory for indicator calculation: " + functionCall);
        }
    }

    class EndOfFileException extends MQLException
    {
        public EndOfFileException(String functionCall)
        {
            super("End of file: " + functionCall);
        }
    }

    class SomeFileErrorException extends MQLException
    {
        public SomeFileErrorException(String functionCall)
        {
            super("Some file error: " + functionCall);
        }
    }

    class WrongFileNameException extends MQLException
    {
        public WrongFileNameException(String functionCall)
        {
            super("Wrong file name: " + functionCall);
        }
    }

    class TooManyOpenedFilesException extends MQLException
    {
        public TooManyOpenedFilesException(String functionCall)
        {
            super("Too many opened files: " + functionCall);
        }
    }

    class CannotOpenFileException extends MQLException
    {
        public CannotOpenFileException(String functionCall)
        {
            super("Cannot open file: " + functionCall);
        }
    }

    class IncompatibleFileaccessException extends MQLException
    {
        public IncompatibleFileaccessException(String functionCall)
        {
            super("Incompatible access to a file: " + functionCall);
        }
    }

    class NoOrderSelectedException extends MQLException
    {
        public NoOrderSelectedException(String functionCall)
        {
            super("No order selected: " + functionCall);
        }
    }

    class UnknownSymbolException extends MQLException
    {
        public UnknownSymbolException(String functionCall)
        {
            super("Unknown symbol: " + functionCall);
        }
    }

    class InvalidPriceParamException extends MQLException
    {
        public InvalidPriceParamException(String functionCall)
        {
            super("Invalid price: " + functionCall);
        }
    }

    class InvalidTicketException extends MQLException
    {
        public InvalidTicketException(String functionCall)
        {
            super("Invalid ticket: " + functionCall);
        }
    }

    class TradeNotAllowedException extends MQLException
    {
        public TradeNotAllowedException(String functionCall)
        {
            super("Trade is not allowed. Enable checkbox: " + functionCall);
        }
    }

    class LongsNotAllowedException extends MQLException
    {
        public LongsNotAllowedException(String functionCall)
        {
            super("Longs are not allowed. Check the Expert Advisor properties: " + functionCall);
        }
    }

    class ShortsNotAllowedExceptionException extends MQLException
    {
        public ShortsNotAllowedExceptionException(String functionCall)
        {
            super("Shorts are not allowed. Check the Expert Advisor properties: " + functionCall);
        }
    }

    class TradeExpertDisabledByServerException extends MQLException
    {
        public TradeExpertDisabledByServerException(String functionCall)
        {
            super("Automated trading by Expert Advisors/Scripts disabled by trade server: " + functionCall);
        }
    }

    class ObjectAlreadyExistsException extends MQLException
    {
        public ObjectAlreadyExistsException(String functionCall)
        {
            super("Object already exists: " + functionCall);
        }
    }

    class UnknownObjectPropertyException extends MQLException
    {
        public UnknownObjectPropertyException(String functionCall)
        {
            super("Unknown object property: " + functionCall);
        }
    }

    class ObjectDoesNotExistException extends MQLException
    {
        public ObjectDoesNotExistException(String functionCall)
        {
            super("Object does not exist: " + functionCall);
        }
    }

    class UnknownObjectTypeException extends MQLException
    {
        public UnknownObjectTypeException(String functionCall)
        {
            super("Unknown object type: " + functionCall);
        }
    }

    class NoObjectNameException extends MQLException
    {
        public NoObjectNameException(String functionCall)
        {
            super("No object name: " + functionCall);
        }
    }

    class ObjectCoordinatesErrorException extends MQLException
    {
        public ObjectCoordinatesErrorException(String functionCall)
        {
            super("Object coordinates error: " + functionCall);
        }
    }

    class NoSpecifiedSubwindowException extends MQLException
    {
        public NoSpecifiedSubwindowException(String functionCall)
        {
            super("No specified subwindow: " + functionCall);
        }
    }

    class SomeObjectErrorException extends MQLException
    {
        public SomeObjectErrorException(String functionCall)
        {
            super("Graphical object error: " + functionCall);
        }
    }

    class ChartPropInvalidException extends MQLException
    {
        public ChartPropInvalidException(String functionCall)
        {
            super("Unknown chart property: " + functionCall);
        }
    }

    class ChartNotFoundException extends MQLException
    {
        public ChartNotFoundException(String functionCall)
        {
            super("Chart not found: " + functionCall);
        }
    }

    class ChartwindowNotFoundException extends MQLException
    {
        public ChartwindowNotFoundException(String functionCall)
        {
            super("Chart subwindow not found: " + functionCall);
        }
    }

    class ChartindicatorNotFoundException extends MQLException
    {
        public ChartindicatorNotFoundException(String functionCall)
        {
            super("Chart indicator not found: " + functionCall);
        }
    }

    class SymbolSelectException extends MQLException
    {
        public SymbolSelectException(String functionCall)
        {
            super("Symbol select error: " + functionCall);
        }
    }

    class NotificationErrorException extends MQLException
    {
        public NotificationErrorException(String functionCall)
        {
            super("Notification error: " + functionCall);
        }
    }

    class NotificationParameterException extends MQLException
    {
        public NotificationParameterException(String functionCall)
        {
            super("Notification parameter error: " + functionCall);
        }
    }

    class NotificationSettingsException extends MQLException
    {
        public NotificationSettingsException(String functionCall)
        {
            super("Notifications disabled: " + functionCall);
        }
    }

    class NotificationTooFrequentException extends MQLException
    {
        public NotificationTooFrequentException(String functionCall)
        {
            super("Notification send too frequent: " + functionCall);
        }
    }

    class FtpNoserverException extends MQLException
    {
        public FtpNoserverException(String functionCall)
        {
            super("FTP server is not specified: " + functionCall);
        }
    }

    class FtpNologinException extends MQLException
    {
        public FtpNologinException(String functionCall)
        {
            super("FTP login is not specified: " + functionCall);
        }
    }

    class FtpConnectFailedException extends MQLException
    {
        public FtpConnectFailedException(String functionCall)
        {
            super("FTP connection failed: " + functionCall);
        }
    }

    class FtpClosedException extends MQLException
    {
        public FtpClosedException(String functionCall)
        {
            super("FTP connection closed: " + functionCall);
        }
    }

    class FtpChangedirException extends MQLException
    {
        public FtpChangedirException(String functionCall)
        {
            super("FTP path not found on server: " + functionCall);
        }
    }

    class FtpFileErrorException extends MQLException
    {
        public FtpFileErrorException(String functionCall)
        {
            super("File not found in the MQL4\\Files directory to send on FTP server: " + functionCall);
        }
    }

    class FtpErrorException extends MQLException
    {
        public FtpErrorException(String functionCall)
        {
            super("Common error during FTP data transmission: " + functionCall);
        }
    }

    class FileTooManyOpenedException extends MQLException
    {
        public FileTooManyOpenedException(String functionCall)
        {
            super("Too many opened files: " + functionCall);
        }
    }

    class FileWrongFilenameException extends MQLException
    {
        public FileWrongFilenameException(String functionCall)
        {
            super("Wrong file name: " + functionCall);
        }
    }

    class FileTooLongFilenameException extends MQLException
    {
        public FileTooLongFilenameException(String functionCall)
        {
            super("Too long file name: " + functionCall);
        }
    }

    class FileCannotOpenException extends MQLException
    {
        public FileCannotOpenException(String functionCall)
        {
            super("Cannot open file: " + functionCall);
        }
    }

    class FileBufferAllocationErrorException extends MQLException
    {
        public FileBufferAllocationErrorException(String functionCall)
        {
            super("Text file buffer allocation error: " + functionCall);
        }
    }

    class FileCannotDeleteException extends MQLException
    {
        public FileCannotDeleteException(String functionCall)
        {
            super("Cannot delete file: " + functionCall);
        }
    }

    class FileInvalidHandleException extends MQLException
    {
        public FileInvalidHandleException(String functionCall)
        {
            super("Invalid file handle (file closed or was not opened): " + functionCall);
        }
    }

    class FileWrongHandleException extends MQLException
    {
        public FileWrongHandleException(String functionCall)
        {
            super("Wrong file handle (handle index is out of handle table): " + functionCall);
        }
    }

    class FileNotTowriteException extends MQLException
    {
        public FileNotTowriteException(String functionCall)
        {
            super("File must be opened with FILE_WRITE flag: " + functionCall);
        }
    }

    class FileNotToreadException extends MQLException
    {
        public FileNotToreadException(String functionCall)
        {
            super("File must be opened with FILE_READ flag: " + functionCall);
        }
    }

    class FileNotBinException extends MQLException
    {
        public FileNotBinException(String functionCall)
        {
            super("File must be opened with FILE_BIN flag: " + functionCall);
        }
    }

    class FileNotTxtException extends MQLException
    {
        public FileNotTxtException(String functionCall)
        {
            super("File must be opened with FILE_TXT flag: " + functionCall);
        }
    }

    class FileNotTxtorcsvException extends MQLException
    {
        public FileNotTxtorcsvException(String functionCall)
        {
            super("File must be opened with FILE_TXT or FILE_CSV flag: " + functionCall);
        }
    }

    class FileNotCsvException extends MQLException
    {
        public FileNotCsvException(String functionCall)
        {
            super("File must be opened with FILE_CSV flag: " + functionCall);
        }
    }

    class FileReadErrorException extends MQLException
    {
        public FileReadErrorException(String functionCall)
        {
            super("File read error: " + functionCall);
        }
    }

    class FileWriteErrorException extends MQLException
    {
        public FileWriteErrorException(String functionCall)
        {
            super("File write error: " + functionCall);
        }
    }

    class FileBinStringsizeException extends MQLException
    {
        public FileBinStringsizeException(String functionCall)
        {
            super("String size must be specified for binary file: " + functionCall);
        }
    }

    class FileIncompatibleException extends MQLException
    {
        public FileIncompatibleException(String functionCall)
        {
            super("Incompatible file (for string arrays-TXT, for others-BIN): " + functionCall);
        }
    }

    class FileIsDirectoryException extends MQLException
    {
        public FileIsDirectoryException(String functionCall)
        {
            super("File is directory not file: " + functionCall);
        }
    }

    class FileNotExistException extends MQLException
    {
        public FileNotExistException(String functionCall)
        {
            super("File does not exist: " + functionCall);
        }
    }

    class FileCannotRewriteException extends MQLException
    {
        public FileCannotRewriteException(String functionCall)
        {
            super("File cannot be rewritten: " + functionCall);
        }
    }

    class FileWrongDirectorynameException extends MQLException
    {
        public FileWrongDirectorynameException(String functionCall)
        {
            super("Wrong directory name: " + functionCall);
        }
    }

    class FileDirectoryNotExistException extends MQLException
    {
        public FileDirectoryNotExistException(String functionCall)
        {
            super("Directory does not exist: " + functionCall);
        }
    }

    class FileNotDirectoryException extends MQLException
    {
        public FileNotDirectoryException(String functionCall)
        {
            super("Specified file is not directory: " + functionCall);
        }
    }

    class FileCannotDeleteDirectoryException extends MQLException
    {
        public FileCannotDeleteDirectoryException(String functionCall)
        {
            super("Cannot delete directory: " + functionCall);
        }
    }

    class FileCannotCleanDirectoryException extends MQLException
    {
        public FileCannotCleanDirectoryException(String functionCall)
        {
            super("Cannot clean directory: " + functionCall);
        }
    }

    class FileArrayresizeErrorException extends MQLException
    {
        public FileArrayresizeErrorException(String functionCall)
        {
            super("Array resize error: " + functionCall);
        }
    }

    class FileStringresizeErrorException extends MQLException
    {
        public FileStringresizeErrorException(String functionCall)
        {
            super("String resize error: " + functionCall);
        }
    }

    class FileStructWithObjectsException extends MQLException
    {
        public FileStructWithObjectsException(String functionCall)
        {
            super("Structure contains strings or dynamic arrays: " + functionCall);
        }
    }

    class WebrequestInvalidAddressException extends MQLException
    {
        public WebrequestInvalidAddressException(String functionCall)
        {
            super("Invalid URL: " + functionCall);
        }
    }

    class WebrequestConnectFailedException extends MQLException
    {
        public WebrequestConnectFailedException(String functionCall)
        {
            super("Failed to connect to specified URL: " + functionCall);
        }
    }

    class WebrequestTimeoutException extends MQLException
    {
        public WebrequestTimeoutException(String functionCall)
        {
            super("Timeout exceeded: " + functionCall);
        }
    }

    class WebrequestRequestFailedException extends MQLException
    {
        public WebrequestRequestFailedException(String functionCall)
        {
            super("HTTP request failed: " + functionCall);
        }
    }

    class UserErrorFirstException extends MQLException
    {
        public UserErrorFirstException(String functionCall)
        {
            super("User defined errors start with this code: " + functionCall);
        }
    }

}