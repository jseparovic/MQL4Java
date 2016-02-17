/**
 * Copyright 2016 Jason Separovic
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jseppa.mql4java.base.mql;

import com.jseppa.mql4java.base.enums.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class MQLBase extends MQLExpert
{

    private String symbol_name;
    private TIMEFRAME timeframe;
    private Date start_time;
    private Date stop_time;


    public MQLBase(long ix)
    {
        super(ix);
    }

    /**
     * Alert
     * Description: Displays a message in a separate window.
     * URL: http://docs.mql4.com/common/alert.html
     *
     * @param argument /**
     * @param argument
     * @throws Exception
     */
    void Alert(String argument) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(argument);
        int id = getCommandManager().execCommand(MQLCommand.Alert_1, parameters); // MQLCommand ENUM = 1
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
    }

    /**
     * Comment
     * Description: This function outputs a comment defined by a user in the top left corner of a chart.
     * URL: http://docs.mql4.com/common/comment.html
     *
     * @param argument [in] Any values, separated by commas. To delimit output information into several lines, a line break symbol "\n" or "\r\n" is used. Number of parameters cannot exceed 64. Total length of the input comment (including invisible symbols) cannot exceed 2045 characters (excess symbols will be cut out during output).
     * @throws Exception
     */
    public void Comment(String argument) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(argument);
        int id = getCommandManager().execCommand(MQLCommand.Comment_1, parameters); // MQLCommand ENUM = 2
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
    }

    /**
     * SendFTP
     * Description: Sends a file at the address, specified in the setting window of the "FTP" tab.
     * URL: http://docs.mql4.com/common/sendftp.html
     *
     * @param filename [in] Name of sent file.
     * @param ftp_path [in] FTP catalog. If a directory is not specified, directory described in settings is used.
     * @throws Exception
     */
    public boolean SendFTP(String filename, String ftp_path) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(filename);
        parameters.add(ftp_path);
        int id = getCommandManager().execCommand(MQLCommand.SendFTP_1, parameters); // MQLCommand ENUM = 3
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (boolean) getCommandManager().getCommandResult(id);
    }

    /**
     * SendNotification
     * Description: Sends push notifications to the mobile terminals, whose MetaQuotes IDs are specified in the "Notifications" tab.
     * URL: http://docs.mql4.com/common/sendnotification.html
     *
     * @param text [in] The text of the notification. The message length should not exceed 255 characters.
     * @throws Exception
     */
    public boolean SendNotification(String text) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(text);
        int id = getCommandManager().execCommand(MQLCommand.SendNotification_1, parameters); // MQLCommand ENUM = 4
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (boolean) getCommandManager().getCommandResult(id);
    }

    /**
     * SendMail
     * Description: Sends an email at the address specified in the settings window of the "Email" tab.
     * URL: http://docs.mql4.com/common/sendmail.html
     *
     * @param subject   [in] Email header.
     * @param some_text [in] Email body.
     * @throws Exception
     */
    public boolean SendMail(String subject, String some_text) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(subject);
        parameters.add(some_text);
        int id = getCommandManager().execCommand(MQLCommand.SendMail_1, parameters); // MQLCommand ENUM = 5
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (boolean) getCommandManager().getCommandResult(id);
    }

    /**
     * AccountInfoDouble
     * Description: Returns the value of the corresponding account property.
     * URL: http://docs.mql4.com/account/accountinfodouble.html
     *
     * @param property_id [in] Identifier of the property. The value can be one of the values of .
     * @throws Exception
     */
    public double AccountInfoDouble(int property_id) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(property_id);
        int id = getCommandManager().execCommand(MQLCommand.AccountInfoDouble_1, parameters); // MQLCommand ENUM = 6
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (double) getCommandManager().getCommandResult(id);
    }

    /**
     * AccountInfoInteger
     * Description: Returns the value of the properties of the account.
     * URL: http://docs.mql4.com/account/accountinfointeger.html
     *
     * @param property_id [in] Identifier of the property. The value can be one of the values of .
     * @throws Exception
     */
    public long AccountInfoInteger(int property_id) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(property_id);
        int id = getCommandManager().execCommand(MQLCommand.AccountInfoInteger_1, parameters); // MQLCommand ENUM = 7
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (long) getCommandManager().getCommandResult(id);
    }

    /**
     * AccountInfoString
     * Description: Returns the value of the corresponding account property.
     * URL: http://docs.mql4.com/account/accountinfoString.html
     *
     * @param property_id [in] Identifier of the property. The value can be one of the values of .
     * @throws Exception
     */
    public String AccountInfoString(int property_id) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(property_id);
        int id = getCommandManager().execCommand(MQLCommand.AccountInfoString_1, parameters); // MQLCommand ENUM = 8
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (String) getCommandManager().getCommandResult(id);
    }

    /**
     * AccountBalance
     * Description: Returns balance value of the current account.
     * URL: http://docs.mql4.com/account/accountbalance.html
     *
     * @throws Exception
     */
    public double AccountBalance() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.AccountBalance_1, parameters); // MQLCommand ENUM = 9
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (double) getCommandManager().getCommandResult(id);
    }

    /**
     * AccountCredit
     * Description: Returns credit value of the current account.
     * URL: http://docs.mql4.com/account/accountcredit.html
     *
     * @throws Exception
     */
    public double AccountCredit() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.AccountCredit_1, parameters); // MQLCommand ENUM = 10
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (double) getCommandManager().getCommandResult(id);
    }

    /**
     * AccountCompany
     * Description: Returns the brokerage company name where the current account was registered.
     * URL: http://docs.mql4.com/account/accountcompany.html
     *
     * @throws Exception
     */
    public String AccountCompany() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.AccountCompany_1, parameters); // MQLCommand ENUM = 11
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (String) getCommandManager().getCommandResult(id);
    }

    /**
     * AccountCurrency
     * Description: Returns currency name of the current account.
     * URL: http://docs.mql4.com/account/accountcurrency.html
     *
     * @throws Exception
     */
    public String AccountCurrency() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.AccountCurrency_1, parameters); // MQLCommand ENUM = 12
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (String) getCommandManager().getCommandResult(id);
    }

    /**
     * AccountEquity
     * Description: Returns equity value of the current account.
     * URL: http://docs.mql4.com/account/accountequity.html
     *
     * @throws Exception
     */
    public double AccountEquity() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.AccountEquity_1, parameters); // MQLCommand ENUM = 13
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (double) getCommandManager().getCommandResult(id);
    }

    /**
     * AccountFreeMargin
     * Description: Returns free margin value of the current account.
     * URL: http://docs.mql4.com/account/accountfreemargin.html
     *
     * @throws Exception
     */
    public double AccountFreeMargin() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.AccountFreeMargin_1, parameters); // MQLCommand ENUM = 14
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (double) getCommandManager().getCommandResult(id);
    }

    /**
     * AccountFreeMarginCheck
     * Description: Returns free margin that remains after the specified order has been opened at the current price on the current account.
     * URL: http://docs.mql4.com/account/accountfreemargincheck.html
     *
     * @param symbol [in] Symbol for trading operation.
     * @param cmd    [in] Operation type. It can be either OP_BUY or OP_SELL.
     * @param volume [in] Number of lots.
     * @throws Exception
     */
    public double AccountFreeMarginCheck(String symbol, int cmd, double volume) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(symbol);
        parameters.add(cmd);
        parameters.add(volume);
        int id = getCommandManager().execCommand(MQLCommand.AccountFreeMarginCheck_1, parameters); // MQLCommand ENUM = 15
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (double) getCommandManager().getCommandResult(id);
    }

    /**
     * AccountFreeMarginMode
     * Description: Returns the calculation mode of free margin allowed to open orders on the current account.
     * URL: http://docs.mql4.com/account/accountfreemarginmode.html
     *
     * @throws Exception
     */
    public double AccountFreeMarginMode() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.AccountFreeMarginMode_1, parameters); // MQLCommand ENUM = 16
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (double) getCommandManager().getCommandResult(id);
    }

    /**
     * AccountLeverage
     * Description: Returns leverage of the current account.
     * URL: http://docs.mql4.com/account/accountleverage.html
     *
     * @throws Exception
     */
    public int AccountLeverage() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.AccountLeverage_1, parameters); // MQLCommand ENUM = 17
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (int) getCommandManager().getCommandResult(id);
    }

    /**
     * AccountMargin
     * Description: Returns margin value of the current account.
     * URL: http://docs.mql4.com/account/accountmargin.html
     *
     * @throws Exception
     */
    public double AccountMargin() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.AccountMargin_1, parameters); // MQLCommand ENUM = 18
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (double) getCommandManager().getCommandResult(id);
    }

    /**
     * AccountName
     * Description: Returns the current account name.
     * URL: http://docs.mql4.com/account/accountname.html
     *
     * @throws Exception
     */
    public String AccountName() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.AccountName_1, parameters); // MQLCommand ENUM = 19
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (String) getCommandManager().getCommandResult(id);
    }

    /**
     * AccountNumber
     * Description: Returns the current account number.
     * URL: http://docs.mql4.com/account/accountnumber.html
     *
     * @throws Exception
     */
    public int AccountNumber() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.AccountNumber_1, parameters); // MQLCommand ENUM = 20
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (int) getCommandManager().getCommandResult(id);
    }

    /**
     * AccountProfit
     * Description: Returns profit value of the current account.
     * URL: http://docs.mql4.com/account/accountprofit.html
     *
     * @throws Exception
     */
    public double AccountProfit() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.AccountProfit_1, parameters); // MQLCommand ENUM = 21
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (double) getCommandManager().getCommandResult(id);
    }

    /**
     * AccountServer
     * Description: Returns the connected server name.
     * URL: http://docs.mql4.com/account/accountserver.html
     *
     * @throws Exception
     */
    public String AccountServer() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.AccountServer_1, parameters); // MQLCommand ENUM = 22
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (String) getCommandManager().getCommandResult(id);
    }

    /**
     * AccountStopoutLevel
     * Description: Returns the value of the Stop Out level.
     * URL: http://docs.mql4.com/account/accountstopoutlevel.html
     *
     * @throws Exception
     */
    public int AccountStopoutLevel() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.AccountStopoutLevel_1, parameters); // MQLCommand ENUM = 23
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (int) getCommandManager().getCommandResult(id);
    }

    /**
     * AccountStopoutMode
     * Description: Returns the calculation mode for the Stop Out level.
     * URL: http://docs.mql4.com/account/accountstopoutmode.html
     *
     * @throws Exception
     */
    public int AccountStopoutMode() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.AccountStopoutMode_1, parameters); // MQLCommand ENUM = 24
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (int) getCommandManager().getCommandResult(id);
    }

    /**
     * GetLastError
     * Description: Returns the contents of the
     * URL: http://docs.mql4.com/check/getlasterror.html
     *
     * @throws Exception
     */
    public int GetLastError() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.GetLastError_1, parameters); // MQLCommand ENUM = 25
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (int) getCommandManager().getCommandResult(id);
    }

    /**
     * IsStopped
     * Description: Checks the forced shutdown of an mql4 program.
     * URL: http://docs.mql4.com/check/isstopped.html
     *
     * @throws Exception
     */
    public boolean IsStopped() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.IsStopped_1, parameters); // MQLCommand ENUM = 26
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (boolean) getCommandManager().getCommandResult(id);
    }

    /**
     * UninitializeReason
     * Description: Returns the code of a
     * URL: http://docs.mql4.com/check/uninitializereason.html
     *
     * @throws Exception
     */
    public int UninitializeReason() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.UninitializeReason_1, parameters); // MQLCommand ENUM = 27
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (int) getCommandManager().getCommandResult(id);
    }

    /**
     * MQLInfoInteger
     * Description: Returns the value of a corresponding property of a running mql4 program.
     * URL: http://docs.mql4.com/check/mqlinfointeger.html
     *
     * @param property_id [in] Identifier of a property. Can be one of values of the enumeration.
     * @throws Exception
     */
    public int MQLInfoInteger(int property_id) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(property_id);
        int id = getCommandManager().execCommand(MQLCommand.MQLInfoInteger_1, parameters); // MQLCommand ENUM = 28
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (int) getCommandManager().getCommandResult(id);
    }

    /**
     * MQLInfoString
     * Description: Returns the value of a corresponding property of a running MQL4 program.
     * URL: http://docs.mql4.com/check/mqlinfoString.html
     *
     * @param property_id [in] Identifier of a property. Can be one of the enumeration.
     * @throws Exception
     */
    public String MQLInfoString(int property_id) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(property_id);
        int id = getCommandManager().execCommand(MQLCommand.MQLInfoString_1, parameters); // MQLCommand ENUM = 29
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (String) getCommandManager().getCommandResult(id);
    }

    /**
     * MQLSetInteger
     * Description: Sets the value of the
     * URL: http://docs.mql4.com/check/mqlsetinteger.html
     *
     * @param property_id    [in] Identifier of a property. Only is supported, as other properties cannot be changed.
     * @param property_value [in] Value of property. Can be one of the .
     * @throws Exception
     */
    public void MQLSetInteger(int property_id, int property_value) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(property_id);
        parameters.add(property_value);
        int id = getCommandManager().execCommand(MQLCommand.MQLSetInteger_1, parameters); // MQLCommand ENUM = 30
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
    }

    /**
     * TerminalInfoInteger
     * Description: Returns the value of a corresponding property of the mql4 program environment.
     * URL: http://docs.mql4.com/check/terminalinfointeger.html
     *
     * @param property_id [in] Identifier of a property. Can be one of the values of the enumeration.
     * @throws Exception
     */
    public int TerminalInfoInteger(int property_id) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(property_id);
        int id = getCommandManager().execCommand(MQLCommand.TerminalInfoInteger_1, parameters); // MQLCommand ENUM = 31
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (int) getCommandManager().getCommandResult(id);
    }

    /**
     * TerminalInfoDouble
     * Description: Returns the value of a corresponding property of the mql4 program environment.
     * URL: http://docs.mql4.com/check/terminalinfodouble.html
     *
     * @param property_id [in] Identifier of a property. Can be one of the values of the enumeration.
     * @throws Exception
     */
    public double TerminalInfoDouble(int property_id) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(property_id);
        int id = getCommandManager().execCommand(MQLCommand.TerminalInfoDouble_1, parameters); // MQLCommand ENUM = 32
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (double) getCommandManager().getCommandResult(id);
    }

    /**
     * TerminalInfoString
     * Description: Returns the value of a corresponding property of the mql4 program environment. The property must be of String type.
     * URL: http://docs.mql4.com/check/terminalinfoString.html
     *
     * @param property_id [in] Identifier of a property. Can be one of the values of the enumeration.
     * @throws Exception
     */
    public String TerminalInfoString(int property_id) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(property_id);
        int id = getCommandManager().execCommand(MQLCommand.TerminalInfoString_1, parameters); // MQLCommand ENUM = 33
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (String) getCommandManager().getCommandResult(id);
    }

    /**
     * Symbol
     * Description: Returns the name of a symbol of the current chart.
     * URL: http://docs.mql4.com/check/symbol.html
     *
     * @throws Exception
     */
    public String Symbol() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.Symbol_1, parameters); // MQLCommand ENUM = 34
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (String) getCommandManager().getCommandResult(id);
    }

    /**
     * Period
     * Description: Returns the current chart timeframe.
     * URL: http://docs.mql4.com/check/period.html
     *
     * @throws Exception
     */
    public int Period() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.Period_1, parameters); // MQLCommand ENUM = 35
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (int) getCommandManager().getCommandResult(id);
    }

    /**
     * Digits
     * Description: Returns the number of decimal digits determining the accuracy of price of the current chart symbol.
     * URL: http://docs.mql4.com/check/digits.html
     *
     * @throws Exception
     */
    public int Digits() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.Digits_1, parameters); // MQLCommand ENUM = 36
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (int) getCommandManager().getCommandResult(id);
    }

    /**
     * Point
     * Description: Returns the point size of the current symbol in the quote currency.
     * URL: http://docs.mql4.com/check/point.html
     *
     * @throws Exception
     */
    public double Point() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.Point_1, parameters); // MQLCommand ENUM = 37
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (double) getCommandManager().getCommandResult(id);
    }

    /**
     * IsConnected
     * Description: Checks connection between client terminal and server.
     * URL: http://docs.mql4.com/check/isconnected.html
     *
     * @throws Exception
     */
    public boolean IsConnected() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.IsConnected_1, parameters); // MQLCommand ENUM = 38
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (boolean) getCommandManager().getCommandResult(id);
    }

    /**
     * IsDemo
     * Description: Checks if the Expert Advisor runs on a demo account.
     * URL: http://docs.mql4.com/check/isdemo.html
     *
     * @throws Exception
     */
    public boolean IsDemo() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.IsDemo_1, parameters); // MQLCommand ENUM = 39
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (boolean) getCommandManager().getCommandResult(id);
    }

    /**
     * IsDllsAllowed
     * Description: Checks if the DLL function call is allowed for the Expert Advisor.
     * URL: http://docs.mql4.com/check/isdllsallowed.html
     *
     * @throws Exception
     */
    public boolean IsDllsAllowed() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.IsDllsAllowed_1, parameters); // MQLCommand ENUM = 40
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (boolean) getCommandManager().getCommandResult(id);
    }

    /**
     * IsExpertEnabled
     * Description: Checks if Expert Advisors are enabled for running.
     * URL: http://docs.mql4.com/check/isexpertenabled.html
     *
     * @throws Exception
     */
    public boolean IsExpertEnabled() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.IsExpertEnabled_1, parameters); // MQLCommand ENUM = 41
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (boolean) getCommandManager().getCommandResult(id);
    }

    /**
     * IsLibrariesAllowed
     * Description: Checks if the Expert Advisor can call library function.
     * URL: http://docs.mql4.com/check/islibrariesallowed.html
     *
     * @throws Exception
     */
    public boolean IsLibrariesAllowed() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.IsLibrariesAllowed_1, parameters); // MQLCommand ENUM = 42
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (boolean) getCommandManager().getCommandResult(id);
    }

    /**
     * IsOptimization
     * Description: Checks if Expert Advisor runs in the Strategy Tester optimization mode.
     * URL: http://docs.mql4.com/check/isoptimization.html
     *
     * @throws Exception
     */
    public boolean IsOptimization() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.IsOptimization_1, parameters); // MQLCommand ENUM = 43
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (boolean) getCommandManager().getCommandResult(id);
    }

    /**
     * IsTesting
     * Description: Checks
     * URL: http://docs.mql4.com/check/istesting.html
     *
     * @throws Exception
     */
    public boolean IsTesting() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.IsTesting_1, parameters); // MQLCommand ENUM = 44
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (boolean) getCommandManager().getCommandResult(id);
    }

    /**
     * IsTradeAllowed
     * Description: Checks
     * URL: http://docs.mql4.com/check/istradeallowed.html
     *
     * @throws Exception
     */
    public boolean IsTradeAllowed() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.IsTradeAllowed_1, parameters); // MQLCommand ENUM = 45
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (boolean) getCommandManager().getCommandResult(id);
    }

    /**
     * IsTradeAllowed
     * Description: Checks
     * URL: http://docs.mql4.com/check/istradeallowed.html
     *
     * @param symbol      [in] Symbol.
     * @param tested_time [in] Time to check status.
     * @throws Exception
     */
    public boolean IsTradeAllowed(String symbol, Date tested_time) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(symbol);
        parameters.add(tested_time);
        int id = getCommandManager().execCommand(MQLCommand.IsTradeAllowed_2, parameters); // MQLCommand ENUM = 45
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (boolean) getCommandManager().getCommandResult(id);
    }

    /**
     * IsTradeContextBusy
     * Description: Returns the information about trade context.
     * URL: http://docs.mql4.com/check/istradecontextbusy.html
     *
     * @throws Exception
     */
    public boolean IsTradeContextBusy() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.IsTradeContextBusy_1, parameters); // MQLCommand ENUM = 46
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (boolean) getCommandManager().getCommandResult(id);
    }

    /**
     * IsVisualMode
     * Description: Checks
     * URL: http://docs.mql4.com/check/isvisualmode.html
     *
     * @throws Exception
     */
    public boolean IsVisualMode() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.IsVisualMode_1, parameters); // MQLCommand ENUM = 47
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (boolean) getCommandManager().getCommandResult(id);
    }

    /**
     * TerminalCompany
     * Description: Returns the name of company owning the client terminal.
     * URL: http://docs.mql4.com/check/terminalcompany.html
     *
     * @throws Exception
     */
    public String TerminalCompany() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.TerminalCompany_1, parameters); // MQLCommand ENUM = 48
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (String) getCommandManager().getCommandResult(id);
    }

    /**
     * TerminalName
     * Description: Returns client terminal name.
     * URL: http://docs.mql4.com/check/terminalname.html
     *
     * @throws Exception
     */
    public String TerminalName() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.TerminalName_1, parameters); // MQLCommand ENUM = 49
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (String) getCommandManager().getCommandResult(id);
    }

    /**
     * TerminalPath
     * Description: Returns the directory, from which the client terminal was launched.
     * URL: http://docs.mql4.com/check/terminalpath.html
     *
     * @throws Exception
     */
    public String TerminalPath() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.TerminalPath_1, parameters); // MQLCommand ENUM = 50
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (String) getCommandManager().getCommandResult(id);
    }

    /**
     * MarketInfo
     * Description: Returns various data about securities listed in the "Market Watch" window.
     * URL: http://docs.mql4.com/marketinformation/marketinfo.html
     *
     * @param symbol [in] Symbol name.
     * @param type   [in] Request of information to be returned. Can be any of values of request identifiers.
     * @throws Exception
     */
    public double MarketInfo(String symbol, int type) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(symbol);
        parameters.add(type);
        int id = getCommandManager().execCommand(MQLCommand.MarketInfo_1, parameters); // MQLCommand ENUM = 51
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (double) getCommandManager().getCommandResult(id);
    }

    /**
     * SymbolsTotal
     * Description: Returns the number of available (selected in Market Watch or all) symbols.
     * URL: http://docs.mql4.com/marketinformation/symbolstotal.html
     *
     * @param selected [in] Request mode. Can be true or false.
     * @throws Exception
     */
    public int SymbolsTotal(boolean selected) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(selected);
        int id = getCommandManager().execCommand(MQLCommand.SymbolsTotal_1, parameters); // MQLCommand ENUM = 52
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (int) getCommandManager().getCommandResult(id);
    }

    /**
     * SymbolName
     * Description: Returns the name of a symbol.
     * URL: http://docs.mql4.com/marketinformation/symbolname.html
     *
     * @param pos      [in] Order number of a symbol.
     * @param selected [in] Request mode. If the value is true, the symbol is taken from the list of symbols selected in MarketWatch. If the value is false, the symbol is taken from the general list.
     * @throws Exception
     */
    public String SymbolName(int pos, boolean selected) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(pos);
        parameters.add(selected);
        int id = getCommandManager().execCommand(MQLCommand.SymbolName_1, parameters); // MQLCommand ENUM = 53
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (String) getCommandManager().getCommandResult(id);
    }

    /**
     * SymbolSelect
     * Description: Selects a symbol in the Market Watch window or removes a symbol from the window.
     * URL: http://docs.mql4.com/marketinformation/symbolselect.html
     *
     * @param name   [in] Symbol name.
     * @param select [in] Switch. If the value is false, a symbol should be removed from MarketWatch, otherwise a symbol should be selected in this window. A symbol can't be removed if the symbol chart is open, or there are open orders for this symbol.
     * @throws Exception
     */
    public boolean SymbolSelect(String name, boolean select) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(name);
        parameters.add(select);
        int id = getCommandManager().execCommand(MQLCommand.SymbolSelect_1, parameters); // MQLCommand ENUM = 54
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (boolean) getCommandManager().getCommandResult(id);
    }

    /**
     * RefreshRates
     * Description: Refreshing of data in pre-defined variables and series arrays.
     * URL: http://docs.mql4.com/series/refreshrates.html
     *
     * @throws Exception
     */
    public boolean RefreshRates() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.RefreshRates_1, parameters); // MQLCommand ENUM = 55
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (boolean) getCommandManager().getCommandResult(id);
    }

    /**
     * Bars
     * Description: Returns the number of bars count in the history for a specified symbol and period. There are 2 variants of functions calls.
     * URL: http://docs.mql4.com/series/barsfunction.html
     *
     * @param symbol_name [in] Symbol name.
     * @param timeframe   [in] Period.
     * @throws Exception
     */
    public int Bars(String symbol_name, TIMEFRAME timeframe) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(symbol_name);
        parameters.add(timeframe.toString());
        int id = getCommandManager().execCommand(MQLCommand.Bars_1, parameters); // MQLCommand ENUM = 56
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (int) getCommandManager().getCommandResult(id);
    }

    /**
     * Bars
     * Description: Returns the number of bars count in the history for a specified symbol and period. There are 2 variants of functions calls.
     * URL: http://docs.mql4.com/series/barsfunction.html
     *
     * @param symbol_name [in] Symbol name.
     * @param timeframe   [in] Period.
     * @param start_time  [in] Bar time corresponding to the first element.
     * @param stop_time   [in] Bar time corresponding to the last element.
     * @throws Exception
     */
    public int Bars(String symbol_name, TIMEFRAME timeframe, Date start_time, Date stop_time) throws Exception
    {
        this.symbol_name = symbol_name;
        this.timeframe = timeframe;
        this.start_time = start_time;
        this.stop_time = stop_time;
        List<Object> parameters = new ArrayList<>();
        parameters.add(symbol_name);
        parameters.add(timeframe.toString());
        parameters.add(start_time);
        parameters.add(stop_time);
        int id = getCommandManager().execCommand(MQLCommand.Bars_2, parameters); // MQLCommand ENUM = 56
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (int) getCommandManager().getCommandResult(id);
    }

    /**
     * iBars
     * Description: Returns the number of bars on the specified chart.
     * URL: http://docs.mql4.com/series/ibars.html
     *
     * @param symbol    [in] Symbol the data of which should be used to calculate indicator. means the current symbol.
     * @param timeframe [in] Timeframe. It can be any of enumeration values. 0 means the current chart timeframe.
     * @throws Exception
     */
    public int iBars(String symbol, int timeframe) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(symbol);
        parameters.add(timeframe);
        int id = getCommandManager().execCommand(MQLCommand.iBars_1, parameters); // MQLCommand ENUM = 57
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (int) getCommandManager().getCommandResult(id);
    }

    /**
     * iBarShift
     * Description: Search for a bar by its time. The function returns the index of the bar which covers the specified time.
     * URL: http://docs.mql4.com/series/ibarshift.html
     *
     * @param symbol    [in] Symbol name. means the current symbol.
     * @param timeframe [in] Timeframe. It can be any of enumeration values. 0 means the current chart timeframe.
     * @param time      [in] Time value for searching.
     * @param exact     [in] Return mode when the bar is not found (false - iBarShift returns the nearest, true - iBarShift returns -1).
     * @throws Exception
     */
    public int iBarShift(String symbol, int timeframe, Date time, boolean exact) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(symbol);
        parameters.add(timeframe);
        parameters.add(time);
        parameters.add(exact);
        int id = getCommandManager().execCommand(MQLCommand.iBarShift_1, parameters); // MQLCommand ENUM = 58
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (int) getCommandManager().getCommandResult(id);
    }

    /**
     * iClose
     * Description: Returns Close price value for the bar of specified symbol with timeframe and shift.
     * URL: http://docs.mql4.com/series/iclose.html
     *
     * @param symbol    [in] Symbol name. means the current symbol.
     * @param timeframe [in] Timeframe. It can be any of enumeration values. 0 means the current chart timeframe.
     * @param shift     [in] Index of the value taken from the indicator buffer (shift relative to the current bar the given amount of periods ago).
     * @throws Exception
     */
    public double iClose(String symbol, int timeframe, int shift) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(symbol);
        parameters.add(timeframe);
        parameters.add(shift);
        int id = getCommandManager().execCommand(MQLCommand.iClose_1, parameters); // MQLCommand ENUM = 59
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (double) getCommandManager().getCommandResult(id);
    }

    /**
     * iHigh
     * Description: Returns High price value for the bar of specified symbol with timeframe and shift.
     * URL: http://docs.mql4.com/series/ihigh.html
     *
     * @param symbol    [in] Symbol name. means the current symbol.
     * @param timeframe [in] Timeframe. It can be any of enumeration values. 0 means the current chart timeframe.
     * @param shift     [in] Index of the value taken from the indicator buffer (shift relative to the current bar the given amount of periods ago).
     * @throws Exception
     */
    public double iHigh(String symbol, int timeframe, int shift) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(symbol);
        parameters.add(timeframe);
        parameters.add(shift);
        int id = getCommandManager().execCommand(MQLCommand.iHigh_1, parameters); // MQLCommand ENUM = 60
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (double) getCommandManager().getCommandResult(id);
    }

    /**
     * iHighest
     * Description: Returns the shift of the maximum value over a specific number of bars depending on type.
     * URL: http://docs.mql4.com/series/ihighest.html
     *
     * @param symbol    [in] Symbol the data of which should be used for search. means the current symbol.
     * @param timeframe [in] Timeframe. It can be any of enumeration values. 0 means the current chart timeframe.
     * @param type      [in] Series array identifier. It can be any of the enumeration values.
     * @param count     [in] Number of bars (in direction from the start bar to the back one) on which the search is carried out.
     * @param start     [in] Shift showing the bar, relative to the current bar, that the data should be taken from.
     * @throws Exception
     */
    public int iHighest(String symbol, int timeframe, int type, int count, int start) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(symbol);
        parameters.add(timeframe);
        parameters.add(type);
        parameters.add(count);
        parameters.add(start);
        int id = getCommandManager().execCommand(MQLCommand.iHighest_1, parameters); // MQLCommand ENUM = 61
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (int) getCommandManager().getCommandResult(id);
    }

    /**
     * iLow
     * Description: Returns Low price value for the bar of indicated symbol with timeframe and shift.
     * URL: http://docs.mql4.com/series/ilow.html
     *
     * @param symbol    [in] Symbol name. means the current symbol.
     * @param timeframe [in] Timeframe. It can be any of enumeration values. 0 means the current chart timeframe.
     * @param shift     [in] Index of the value taken from the indicator buffer (shift relative to the current bar the given amount of periods ago).
     * @throws Exception
     */
    public double iLow(String symbol, int timeframe, int shift) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(symbol);
        parameters.add(timeframe);
        parameters.add(shift);
        int id = getCommandManager().execCommand(MQLCommand.iLow_1, parameters); // MQLCommand ENUM = 62
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (double) getCommandManager().getCommandResult(id);
    }

    /**
     * iLowest
     * Description: Returns the shift of the lowest value over a specific number of bars depending on type.
     * URL: http://docs.mql4.com/series/ilowest.html
     *
     * @param symbol    [in] Symbol name. means the current symbol.
     * @param timeframe [in] Timeframe. It can be any of enumeration values. 0 means the current chart timeframe.
     * @param type      [in] Series array identifier. It can be any of the enumeration values.
     * @param count     [in] Number of bars (in direction from the start bar to the back one) on which the search is carried out.
     * @param start     [in] Shift showing the bar, relative to the current bar, that the data should be taken from.
     * @throws Exception
     */
    public int iLowest(String symbol, int timeframe, int type, int count, int start) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(symbol);
        parameters.add(timeframe);
        parameters.add(type);
        parameters.add(count);
        parameters.add(start);
        int id = getCommandManager().execCommand(MQLCommand.iLowest_1, parameters); // MQLCommand ENUM = 63
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (int) getCommandManager().getCommandResult(id);
    }

    /**
     * iOpen
     * Description: Returns Open price value for the bar of specified symbol with timeframe and shift.
     * URL: http://docs.mql4.com/series/iopen.html
     *
     * @param symbol    [in] Symbol name. means the current symbol.
     * @param timeframe [in] Timeframe. It can be any of enumeration values. 0 means the current chart timeframe.
     * @param shift     [in] Index of the value taken from the indicator buffer (shift relative to the current bar the given amount of periods ago).
     * @throws Exception
     */
    public double iOpen(String symbol, int timeframe, int shift) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(symbol);
        parameters.add(timeframe);
        parameters.add(shift);
        int id = getCommandManager().execCommand(MQLCommand.iOpen_1, parameters); // MQLCommand ENUM = 64
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (double) getCommandManager().getCommandResult(id);
    }

    /**
     * iTime
     * Description: Returns Time value for the bar of specified symbol with timeframe and shift.
     * URL: http://docs.mql4.com/series/itime.html
     *
     * @param symbol    [in] Symbol name. means the current symbol.
     * @param timeframe [in] Timeframe. It can be any of enumeration values. 0 means the current chart timeframe.
     * @param shift     [in] Index of the value taken from the indicator buffer (shift relative to the current bar the given amount of periods ago).
     * @throws Exception
     */
    public Date iTime(String symbol, int timeframe, int shift) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(symbol);
        parameters.add(timeframe);
        parameters.add(shift);
        int id = getCommandManager().execCommand(MQLCommand.iTime_1, parameters); // MQLCommand ENUM = 65
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (Date) getCommandManager().getCommandResult(id);
    }

    /**
     * iVolume
     * Description: Returns Tick Volume value for the bar of specified symbol with timeframe and shift.
     * URL: http://docs.mql4.com/series/ivolume.html
     *
     * @param symbol    [in] Symbol name. means the current symbol.
     * @param timeframe [in] Timeframe. It can be any of enumeration values. 0 means the current chart timeframe.
     * @param shift     [in] Index of the value taken from the indicator buffer (shift relative to the current bar the given amount of periods ago).
     * @throws Exception
     */
    public long iVolume(String symbol, int timeframe, int shift) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(symbol);
        parameters.add(timeframe);
        parameters.add(shift);
        int id = getCommandManager().execCommand(MQLCommand.iVolume_1, parameters); // MQLCommand ENUM = 66
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (long) getCommandManager().getCommandResult(id);
    }

    /**
     * ChartApplyTemplate
     * Description: Applies a specific template from a specified file to the chart. The command is added to chart message queue and executed only after all previous commands have been processed.
     * URL: http://docs.mql4.com/chart_operations/chartapplytemplate.html
     *
     * @param chart_id [in] Chart ID. 0 means the current chart.
     * @param filename [in] The name of the file containing the template.
     * @throws Exception
     */
    public boolean ChartApplyTemplate(long chart_id, String filename) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(chart_id);
        parameters.add(filename);
        int id = getCommandManager().execCommand(MQLCommand.ChartApplyTemplate_1, parameters); // MQLCommand ENUM = 67
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (boolean) getCommandManager().getCommandResult(id);
    }

    /**
     * ChartSaveTemplate
     * Description: Saves current chart settings in a template with a specified name. The command is added to chart message queue and executed only after all previous commands have been processed.
     * URL: http://docs.mql4.com/chart_operations/chartsavetemplate.html
     *
     * @param chart_id [in] Chart ID. 0 means the current chart.
     * @param filename [in] The filename to save the template. The ".tpl" extension will be added to the filename automatically; there is no need to specify it. The template is saved in terminal_directory\Profiles\Templates\ and can be used for manual application in the terminal. If a template with the same filename already exists, the contents of this file will be overwritten.
     * @throws Exception
     */
    public boolean ChartSaveTemplate(long chart_id, String filename) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(chart_id);
        parameters.add(filename);
        int id = getCommandManager().execCommand(MQLCommand.ChartSaveTemplate_1, parameters); // MQLCommand ENUM = 68
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (boolean) getCommandManager().getCommandResult(id);
    }

    /**
     * ChartWindowFind
     * Description: The function returns the number of a subwindow where an indicator is drawn. There are 2 variants of the function.
     * URL: http://docs.mql4.com/chart_operations/chartwindowfind.html
     *
     * @param chart_id            [in] Chart ID. 0 denotes the current chart.
     * @param indicator_shortname [in] Short name of the indicator.
     * @throws Exception
     */
    public int ChartWindowFind(long chart_id, String indicator_shortname) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(chart_id);
        parameters.add(indicator_shortname);
        int id = getCommandManager().execCommand(MQLCommand.ChartWindowFind_1, parameters); // MQLCommand ENUM = 69
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (int) getCommandManager().getCommandResult(id);
    }

    /**
     * ChartWindowFind
     * Description: The function returns the number of a subwindow where an indicator is drawn. There are 2 variants of the function.
     * URL: http://docs.mql4.com/chart_operations/chartwindowfind.html
     *
     * @throws Exception
     */
    public int ChartWindowFind() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.ChartWindowFind_2, parameters); // MQLCommand ENUM = 69
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (int) getCommandManager().getCommandResult(id);
    }

    /**
     * ChartOpen
     * Description: Opens a new chart with the specified symbol and period. The command is added to chart message queue and executed only after all previous commands have been processed.
     * URL: http://docs.mql4.com/chart_operations/chartopen.html
     *
     * @param symbol [in] Chart symbol. means the symbol of the current chart (the Expert Advisor is attached to).
     * @param period [in] Chart period (timeframe). Can be one of the values. 0 means the current chart period.
     * @throws Exception
     */
    public long ChartOpen(String symbol, TIMEFRAME period) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(symbol);
        parameters.add(period.toString());
        int id = getCommandManager().execCommand(MQLCommand.ChartOpen_1, parameters); // MQLCommand ENUM = 70
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (long) getCommandManager().getCommandResult(id);
    }

    /**
     * ChartFirst
     * Description: Returns the ID of the first chart of the client terminal.
     * URL: http://docs.mql4.com/chart_operations/chartfirst.html
     *
     * @throws Exception
     */
    public long ChartFirst() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.ChartFirst_1, parameters); // MQLCommand ENUM = 71
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (long) getCommandManager().getCommandResult(id);
    }

    /**
     * ChartNext
     * Description: Returns the chart ID of the chart next to the specified one.
     * URL: http://docs.mql4.com/chart_operations/chartnext.html
     *
     * @param chart_id [in] Chart ID. 0 does not mean the current chart. 0 means "return the first chart ID".
     * @throws Exception
     */
    public long ChartNext(long chart_id) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(chart_id);
        int id = getCommandManager().execCommand(MQLCommand.ChartNext_1, parameters); // MQLCommand ENUM = 72
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (long) getCommandManager().getCommandResult(id);
    }

    /**
     * ChartClose
     * Description: Closes the specified chart.
     * URL: http://docs.mql4.com/chart_operations/chartclose.html
     *
     * @param chart_id [in] Chart ID. 0 means the current chart.
     * @throws Exception
     */
    public boolean ChartClose(long chart_id) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(chart_id);
        int id = getCommandManager().execCommand(MQLCommand.ChartClose_1, parameters); // MQLCommand ENUM = 73
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (boolean) getCommandManager().getCommandResult(id);
    }

    /**
     * ChartSymbol
     * Description: Returns the symbol name for the specified chart.
     * URL: http://docs.mql4.com/chart_operations/chartsymbol.html
     *
     * @param chart_id [in] Chart ID. 0 means the current chart.
     * @throws Exception
     */
    public String ChartSymbol(long chart_id) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(chart_id);
        int id = getCommandManager().execCommand(MQLCommand.ChartSymbol_1, parameters); // MQLCommand ENUM = 74
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (String) getCommandManager().getCommandResult(id);
    }

    /**
     * ChartRedraw
     * Description: This function calls a forced redrawing of a specified chart.
     * URL: http://docs.mql4.com/chart_operations/chartredraw.html
     *
     * @param chart_id [in] Chart ID. 0 means the current chart.
     * @throws Exception
     */
    public void ChartRedraw(long chart_id) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(chart_id);
        int id = getCommandManager().execCommand(MQLCommand.ChartRedraw_1, parameters); // MQLCommand ENUM = 75
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
    }

    /**
     * ChartSetDouble
     * Description: Sets a value for a corresponding property of the specified chart. Chart property should be of a
     * URL: http://docs.mql4.com/chart_operations/chartsetdouble.html
     *
     * @param chart_id [in] Chart ID. 0 means the current chart.
     * @param prop_id  [in] Chart property ID. Can be one of the values (except the read-only properties).
     * @param value    [in] Property value.
     * @throws Exception
     */
    public boolean ChartSetDouble(long chart_id, int prop_id, double value) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(chart_id);
        parameters.add(prop_id);
        parameters.add(value);
        int id = getCommandManager().execCommand(MQLCommand.ChartSetDouble_1, parameters); // MQLCommand ENUM = 76
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (boolean) getCommandManager().getCommandResult(id);
    }

    /**
     * ChartSetInteger
     * Description: Sets a value for a corresponding property of the specified chart. Chart property must be
     * URL: http://docs.mql4.com/chart_operations/chartsetinteger.html
     *
     * @param chart_id [in] Chart ID. 0 means the current chart.
     * @param prop_id  [in] Chart property ID. It can be one of the value (except the read-only properties).
     * @param value    [in] Property value.
     * @throws Exception
     */
    public boolean ChartSetInteger(long chart_id, int prop_id, long value) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(chart_id);
        parameters.add(prop_id);
        parameters.add(value);
        int id = getCommandManager().execCommand(MQLCommand.ChartSetInteger_1, parameters); // MQLCommand ENUM = 77
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (boolean) getCommandManager().getCommandResult(id);
    }

    /**
     * ChartSetInteger
     * Description: Sets a value for a corresponding property of the specified chart. Chart property must be
     * URL: http://docs.mql4.com/chart_operations/chartsetinteger.html
     *
     * @param chart_id    [in] Chart ID. 0 means the current chart.
     * @param property_id
     * @param sub_window  [in] Chart subwindow.
     * @param value       [in] Property value.
     * @throws Exception
     */
    public boolean ChartSetInteger(long chart_id, int property_id, int sub_window, long value) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(chart_id);
        parameters.add(property_id);
        parameters.add(sub_window);
        parameters.add(value);
        int id = getCommandManager().execCommand(MQLCommand.ChartSetInteger_2, parameters); // MQLCommand ENUM = 77
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (boolean) getCommandManager().getCommandResult(id);
    }

    /**
     * ChartSetString
     * Description: Sets a value for a corresponding property of the specified chart. Chart property must be of the String type. The command is added to chart message queue and executed only after all previous commands have been processed.
     * URL: http://docs.mql4.com/chart_operations/chartsetString.html
     *
     * @param chart_id  [in] Chart ID. 0 means the current chart.
     * @param prop_id   [in] Chart property ID. Its value can be one of the values (except the read-only properties).
     * @param str_value [in] Property value String. String length cannot exceed 2045 characters (extra characters will be truncated).
     * @throws Exception
     */
    public boolean ChartSetString(long chart_id, int prop_id, String str_value) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(chart_id);
        parameters.add(prop_id);
        parameters.add(str_value);
        int id = getCommandManager().execCommand(MQLCommand.ChartSetString_1, parameters); // MQLCommand ENUM = 78
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (boolean) getCommandManager().getCommandResult(id);
    }

    /**
     * ChartNavigate
     * Description: Performs shift of the specified chart by the specified number of bars relative to the specified position in the chart. The command is added to chart message queue and executed only after all previous commands have been processed.
     * URL: http://docs.mql4.com/chart_operations/chartnavigate.html
     *
     * @param chart_id [in] Chart ID. 0 means the current chart.
     * @param position [in] Chart position to perform a shift. Can be one of the values.
     * @param shift    [in] Number of bars to shift the chart. Positive value means the right shift (to the end of chart), negative value means the left shift (to the beginning of chart). The zero shift can be used to navigate to the beginning or end of chart.
     * @throws Exception
     */
    public boolean ChartNavigate(long chart_id, int position, int shift) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(chart_id);
        parameters.add(position);
        parameters.add(shift);
        int id = getCommandManager().execCommand(MQLCommand.ChartNavigate_1, parameters); // MQLCommand ENUM = 79
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (boolean) getCommandManager().getCommandResult(id);
    }

    /**
     * ChartID
     * Description: Returns the ID of the current chart.
     * URL: http://docs.mql4.com/chart_operations/chartid.html
     *
     * @throws Exception
     */
    public long ChartID() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.ChartID_1, parameters); // MQLCommand ENUM = 80
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (long) getCommandManager().getCommandResult(id);
    }

    /**
     * ChartIndicatorDelete
     * Description: Removes an indicator with a specified name from the specified chart window. The command is added to chart message queue and executed only after all previous commands have been processed.
     * URL: http://docs.mql4.com/chart_operations/chartindicatordelete.html
     *
     * @param chart_id            [in] Chart ID. 0 denotes the current chart.
     * @param sub_window          [in] Number of the chart subwindow. 0 denotes the main chart subwindow.
     * @param indicator_shortname
     * @throws Exception
     */
    public boolean ChartIndicatorDelete(long chart_id, int sub_window, String indicator_shortname) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(chart_id);
        parameters.add(sub_window);
        parameters.add(indicator_shortname);
        int id = getCommandManager().execCommand(MQLCommand.ChartIndicatorDelete_1, parameters); // MQLCommand ENUM = 81
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (boolean) getCommandManager().getCommandResult(id);
    }

    /**
     * ChartIndicatorName
     * Description: Returns the short name of the indicator by the number in the indicators list on the specified chart window.
     * URL: http://docs.mql4.com/chart_operations/chartindicatorname.html
     *
     * @param chart_id   [in] Chart ID. 0 denotes the current chart.
     * @param sub_window [in] Number of the chart subwindow. 0 denotes the main chart subwindow.
     * @param index      [in] the index of the indicator in the list of indicators. The numeration of indicators start with zero, i.e. the first indicator in the list has the 0 index. To obtain the number of indicators in the list use the function.
     * @throws Exception
     */
    public String ChartIndicatorName(long chart_id, int sub_window, int index) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(chart_id);
        parameters.add(sub_window);
        parameters.add(index);
        int id = getCommandManager().execCommand(MQLCommand.ChartIndicatorName_1, parameters); // MQLCommand ENUM = 82
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (String) getCommandManager().getCommandResult(id);
    }

    /**
     * ChartIndicatorsTotal
     * Description: Returns the number of all indicators applied to the specified chart window.
     * URL: http://docs.mql4.com/chart_operations/chartindicatorstotal.html
     *
     * @param chart_id   [in] Chart ID. 0 denotes the current chart.
     * @param sub_window [in] Number of the chart subwindow. 0 denotes the main chart subwindow.
     * @throws Exception
     */
    public int ChartIndicatorsTotal(long chart_id, int sub_window) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(chart_id);
        parameters.add(sub_window);
        int id = getCommandManager().execCommand(MQLCommand.ChartIndicatorsTotal_1, parameters); // MQLCommand ENUM = 83
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (int) getCommandManager().getCommandResult(id);
    }

    /**
     * ChartWindowOnDropped
     * Description: Returns the number (index) of the chart subwindow the Expert Advisor or script has been dropped to. 0 means the main chart window.
     * URL: http://docs.mql4.com/chart_operations/chartwindowondropped.html
     *
     * @throws Exception
     */
    public int ChartWindowOnDropped() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.ChartWindowOnDropped_1, parameters); // MQLCommand ENUM = 84
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (int) getCommandManager().getCommandResult(id);
    }

    /**
     * ChartPriceOnDropped
     * Description: Returns the price coordinate corresponding to the chart point the Expert Advisor or script has been dropped to.
     * URL: http://docs.mql4.com/chart_operations/chartpriceondropped.html
     *
     * @throws Exception
     */
    public double ChartPriceOnDropped() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.ChartPriceOnDropped_1, parameters); // MQLCommand ENUM = 85
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (double) getCommandManager().getCommandResult(id);
    }

    /**
     * ChartTimeOnDropped
     * Description: Returns the time coordinate corresponding to the chart point the Expert Advisor or script has been dropped to.
     * URL: http://docs.mql4.com/chart_operations/charttimeondropped.html
     *
     * @throws Exception
     */
    public Date ChartTimeOnDropped() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.ChartTimeOnDropped_1, parameters); // MQLCommand ENUM = 86
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (Date) getCommandManager().getCommandResult(id);
    }

    /**
     * ChartXOnDropped
     * Description: Returns the X coordinate of the chart point the Expert Advisor or script has been dropped to.
     * URL: http://docs.mql4.com/chart_operations/chartxondropped.html
     *
     * @throws Exception
     */
    public int ChartXOnDropped() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.ChartXOnDropped_1, parameters); // MQLCommand ENUM = 87
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (int) getCommandManager().getCommandResult(id);
    }

    /**
     * ChartYOnDropped
     * Description: Returns the Y coordinateof the chart point the Expert Advisor or script has been dropped to.
     * URL: http://docs.mql4.com/chart_operations/chartyondropped.html
     *
     * @throws Exception
     */
    public int ChartYOnDropped() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.ChartYOnDropped_1, parameters); // MQLCommand ENUM = 88
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (int) getCommandManager().getCommandResult(id);
    }

    /**
     * ChartSetSymbolPeriod
     * Description: Changes the symbol and period of the specified chart. The function is asynchronous, i.e. it sends the command and does not wait for its execution completion. The command is added to chart message queue and executed only after all previous commands have been processed.
     * URL: http://docs.mql4.com/chart_operations/chartsetsymbolperiod.html
     *
     * @param chart_id [in] Chart ID. 0 means the current chart.
     * @param symbol   [in] Chart symbol. value means the current chart symbol (Expert Advisor is attached to)
     * @param period   [in] Chart period (timeframe). Can be one of the values. 0 means the current chart period.
     * @throws Exception
     */
    public boolean ChartSetSymbolPeriod(long chart_id, String symbol, TIMEFRAME period) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(chart_id);
        parameters.add(symbol);
        parameters.add(period.toString());
        int id = getCommandManager().execCommand(MQLCommand.ChartSetSymbolPeriod_1, parameters); // MQLCommand ENUM = 89
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (boolean) getCommandManager().getCommandResult(id);
    }

    /**
     * ChartScreenShot
     * Description: Saves current chart screen shot as a GIF, PNG or BMP file depending on specified extension. The command is added to chart message queue and executed only after all previous commands have been processed.
     * URL: http://docs.mql4.com/chart_operations/chartscreenshot.html
     *
     * @param chart_id   [in] Chart ID. 0 means the current chart.
     * @param filename   [in] Screenshot file name. Cannot exceed 63 characters. Screenshot files are placed in the \Files directory.
     * @param width      [in] Screenshot width in pixels.
     * @param height     [in] Screenshot height in pixels.
     * @param align_mode [in] Output mode of a narrow screenshot. A value of the enumeration. ALIGN_RIGHT means align to the right margin (the output from the end). ALIGN_LEFT means Left justify.
     * @throws Exception
     */
    public boolean ChartScreenShot(long chart_id, String filename, int width, int height, ALIGN_MODE align_mode) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(chart_id);
        parameters.add(filename);
        parameters.add(width);
        parameters.add(height);
        parameters.add(align_mode.toString());
        int id = getCommandManager().execCommand(MQLCommand.ChartScreenShot_1, parameters); // MQLCommand ENUM = 90
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (boolean) getCommandManager().getCommandResult(id);
    }

    /**
     * WindowBarsPerChart
     * Description: Returns the amount of bars visible on the chart.
     * URL: http://docs.mql4.com/chart_operations/windowbarsperchart.html
     *
     * @throws Exception
     */
    public int WindowBarsPerChart() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.WindowBarsPerChart_1, parameters); // MQLCommand ENUM = 91
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (int) getCommandManager().getCommandResult(id);
    }

    /**
     * WindowExpertName
     * Description: Returns the name of the executed Expert Advisor, script, custom indicator, or library.
     * URL: http://docs.mql4.com/chart_operations/windowexpertname.html
     *
     * @throws Exception
     */
    public String WindowExpertName() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.WindowExpertName_1, parameters); // MQLCommand ENUM = 92
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (String) getCommandManager().getCommandResult(id);
    }

    /**
     * WindowFind
     * Description: Returns the window index containing this specified indicator.
     * URL: http://docs.mql4.com/chart_operations/windowfind.html
     *
     * @param name [in] Indicator short name.
     * @throws Exception
     */
    public int WindowFind(String name) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(name);
        int id = getCommandManager().execCommand(MQLCommand.WindowFind_1, parameters); // MQLCommand ENUM = 93
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (int) getCommandManager().getCommandResult(id);
    }

    /**
     * WindowFirstVisibleBar
     * Description: Returns index of the first visible bar in the current chart window.
     * URL: http://docs.mql4.com/chart_operations/windowfirstvisiblebar.html
     *
     * @throws Exception
     */
    public int WindowFirstVisibleBar() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.WindowFirstVisibleBar_1, parameters); // MQLCommand ENUM = 94
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (int) getCommandManager().getCommandResult(id);
    }

    /**
     * WindowHandle
     * Description: Returns the system handle of the chart window.
     * URL: http://docs.mql4.com/chart_operations/windowhandle.html
     *
     * @param symbol    [in] Symbol.
     * @param timeframe [in] Timeframe. It can be any of enumeration values. 0 means the current chart timeframe.
     * @throws Exception
     */
    public int WindowHandle(String symbol, int timeframe) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(symbol);
        parameters.add(timeframe);
        int id = getCommandManager().execCommand(MQLCommand.WindowHandle_1, parameters); // MQLCommand ENUM = 95
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (int) getCommandManager().getCommandResult(id);
    }

    /**
     * WindowIsVisible
     * Description: Returns the visibility flag of the chart subwindow.
     * URL: http://docs.mql4.com/chart_operations/windowisvisible.html
     *
     * @param index [in] Subwindow index.
     * @throws Exception
     */
    public int WindowIsVisible(int index) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(index);
        int id = getCommandManager().execCommand(MQLCommand.WindowIsVisible_1, parameters); // MQLCommand ENUM = 96
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (int) getCommandManager().getCommandResult(id);
    }

    /**
     * WindowOnDropped
     * Description: Returns the window index where Expert Advisor, custom indicator or script was dropped.
     * URL: http://docs.mql4.com/chart_operations/windowondropped.html
     *
     * @throws Exception
     */
    public int WindowOnDropped() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.WindowOnDropped_1, parameters); // MQLCommand ENUM = 97
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (int) getCommandManager().getCommandResult(id);
    }

    /**
     * WindowPriceMax
     * Description: Returns the maximal value of the vertical scale of the specified subwindow of the current chart.
     * URL: http://docs.mql4.com/chart_operations/windowpricemax.html
     *
     * @param index [in] Chart subwindow index (0 - main chart window).
     * @throws Exception
     */
    public int WindowPriceMax(int index) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(index);
        int id = getCommandManager().execCommand(MQLCommand.WindowPriceMax_1, parameters); // MQLCommand ENUM = 98
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (int) getCommandManager().getCommandResult(id);
    }

    /**
     * WindowPriceMin
     * Description: Returns the minimal value of the vertical scale of the specified subwindow of the current chart.
     * URL: http://docs.mql4.com/chart_operations/windowpricemin.html
     *
     * @param index [in] Chart subwindow index (0 - main chart window).
     * @throws Exception
     */
    public int WindowPriceMin(int index) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(index);
        int id = getCommandManager().execCommand(MQLCommand.WindowPriceMin_1, parameters); // MQLCommand ENUM = 99
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (int) getCommandManager().getCommandResult(id);
    }

    /**
     * WindowPriceOnDropped
     * Description: Returns the price of the chart point where Expert Advisor or script was dropped.
     * URL: http://docs.mql4.com/chart_operations/windowpriceondropped.html
     *
     * @throws Exception
     */
    public double WindowPriceOnDropped() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.WindowPriceOnDropped_1, parameters); // MQLCommand ENUM = 100
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (double) getCommandManager().getCommandResult(id);
    }

    /**
     * WindowRedraw
     * Description: Redraws the current chart forcedly.
     * URL: http://docs.mql4.com/chart_operations/windowredraw.html
     *
     * @throws Exception
     */
    public void WindowRedraw() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.WindowRedraw_1, parameters); // MQLCommand ENUM = 101
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
    }

    /**
     * WindowScreenShot
     * Description: Saves current chart screen shot as a GIF file.
     * URL: http://docs.mql4.com/chart_operations/windowscreenshot.html
     *
     * @param filename    [in] Screen shot file name. Screenshot is saved to \Files folder.
     * @param size_x      [in] Screen shot width in pixels.
     * @param size_y      [in] Screen shot height in pixels.
     * @param start_bar   [in] Index of the first visible bar in the screen shot. If 0 value is set, the current first visible bar will be shot. If no value or negative value has been set, the end-of-chart screen shot will be produced, indent being taken into consideration.
     * @param chart_scale [in] Horizontal chart scale for screen shot. Can be in the range from 0 to 5. If no value or negative value has been set, the current chart scale will be used.
     * @param chart_mode  [in] Chart displaying mode. It can take the following values: CHART_BAR (0 is a sequence of bars), CHART_CANDLE (1 is a sequence of candlesticks), CHART_LINE (2 is a close prices line). If no value or negative value has been set, the chart will be shown in its current mode.
     * @throws Exception
     */
    public boolean WindowScreenShot(String filename, int size_x, int size_y, int start_bar, int chart_scale, int chart_mode) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(filename);
        parameters.add(size_x);
        parameters.add(size_y);
        parameters.add(start_bar);
        parameters.add(chart_scale);
        parameters.add(chart_mode);
        int id = getCommandManager().execCommand(MQLCommand.WindowScreenShot_1, parameters); // MQLCommand ENUM = 102
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (boolean) getCommandManager().getCommandResult(id);
    }

    /**
     * WindowTimeOnDropped
     * Description: Returns the time of the chart point where Expert Advisor or script was dropped.
     * URL: http://docs.mql4.com/chart_operations/windowtimeondropped.html
     *
     * @throws Exception
     */
    public Date WindowTimeOnDropped() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.WindowTimeOnDropped_1, parameters); // MQLCommand ENUM = 103
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (Date) getCommandManager().getCommandResult(id);
    }

    /**
     * WindowsTotal
     * Description: Returns total number of indicator windows on the chart.
     * URL: http://docs.mql4.com/chart_operations/windowstotal.html
     *
     * @throws Exception
     */
    public int WindowsTotal() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.WindowsTotal_1, parameters); // MQLCommand ENUM = 104
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (int) getCommandManager().getCommandResult(id);
    }

    /**
     * WindowXOnDropped
     * Description: Returns the value at X axis in pixels for the chart window client area point at which the Expert Advisor or script was dropped.
     * URL: http://docs.mql4.com/chart_operations/windowxondropped.html
     *
     * @throws Exception
     */
    public int WindowXOnDropped() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.WindowXOnDropped_1, parameters); // MQLCommand ENUM = 105
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (int) getCommandManager().getCommandResult(id);
    }

    /**
     * WindowYOnDropped
     * Description: Returns the value at Y axis in pixels for the chart window client area point at which the Expert Advisor or script was dropped.
     * URL: http://docs.mql4.com/chart_operations/windowyondropped.html
     *
     * @throws Exception
     */
    public int WindowYOnDropped() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.WindowYOnDropped_1, parameters); // MQLCommand ENUM = 106
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (int) getCommandManager().getCommandResult(id);
    }

    /**
     * OrderClose
     * Description: Closes opened order.
     * URL: http://docs.mql4.com/trading/orderclose.html
     *
     * @param ticket      [in] Unique number of the order ticket.
     * @param lots        [in] Number of lots.
     * @param price       [in] Closing price.
     * @param slippage    [in] Value of the maximum price slippage in points.
     * @param arrow_color [in] Color of the closing arrow on the chart. If the parameter is missing or has CLR_NONE value closing arrow will not be drawn on the chart.
     * @throws Exception
     */
    public boolean OrderClose(int ticket, double lots, double price, int slippage, COLOR arrow_color) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(ticket);
        parameters.add(lots);
        parameters.add(price);
        parameters.add(slippage);
        parameters.add(arrow_color);
        int id = getCommandManager().execCommand(MQLCommand.OrderClose_1, parameters); // MQLCommand ENUM = 107
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (boolean) getCommandManager().getCommandResult(id);
    }

    /**
     * OrderCloseBy
     * Description: Closes an opened order by another opposite opened order.
     * URL: http://docs.mql4.com/trading/ordercloseby.html
     *
     * @param ticket      [in] Unique number of the order ticket.
     * @param opposite    [in] Unique number of the opposite order ticket.
     * @param arrow_color [in] Color of the closing arrow on the chart. If the parameter is missing or has CLR_NONE value closing arrow will not be drawn on the chart.
     * @throws Exception
     */
    public boolean OrderCloseBy(int ticket, int opposite, COLOR arrow_color) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(ticket);
        parameters.add(opposite);
        parameters.add(arrow_color);
        int id = getCommandManager().execCommand(MQLCommand.OrderCloseBy_1, parameters); // MQLCommand ENUM = 108
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (boolean) getCommandManager().getCommandResult(id);
    }

    /**
     * OrderClosePrice
     * Description: Returns close price of the currently selected order.
     * URL: http://docs.mql4.com/trading/ordercloseprice.html
     *
     * @throws Exception
     */
    public double OrderClosePrice() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.OrderClosePrice_1, parameters); // MQLCommand ENUM = 109
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (double) getCommandManager().getCommandResult(id);
    }

    /**
     * OrderCloseTime
     * Description: Returns close time of the currently selected order.
     * URL: http://docs.mql4.com/trading/orderclosetime.html
     *
     * @throws Exception
     */
    public Date OrderCloseTime() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.OrderCloseTime_1, parameters); // MQLCommand ENUM = 110
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (Date) getCommandManager().getCommandResult(id);
    }

    /**
     * OrderComment
     * Description: Returns comment of the currently selected order.
     * URL: http://docs.mql4.com/trading/ordercomment.html
     *
     * @throws Exception
     */
    public String OrderComment() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.OrderComment_1, parameters); // MQLCommand ENUM = 111
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (String) getCommandManager().getCommandResult(id);
    }

    /**
     * OrderCommission
     * Description: Returns calculated commission of the currently selected order.
     * URL: http://docs.mql4.com/trading/ordercommission.html
     *
     * @throws Exception
     */
    public double OrderCommission() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.OrderCommission_1, parameters); // MQLCommand ENUM = 112
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (double) getCommandManager().getCommandResult(id);
    }

    /**
     * OrderDelete
     * Description: Deletes previously opened pending order.
     * URL: http://docs.mql4.com/trading/orderdelete.html
     *
     * @param ticket      [in] Unique number of the order ticket.
     * @param arrow_color [in] Color of the arrow on the chart. If the parameter is missing or has CLR_NONE value arrow will not be drawn on the chart.
     * @throws Exception
     */
    public boolean OrderDelete(int ticket, COLOR arrow_color) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(ticket);
        parameters.add(arrow_color);
        int id = getCommandManager().execCommand(MQLCommand.OrderDelete_1, parameters); // MQLCommand ENUM = 113
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (boolean) getCommandManager().getCommandResult(id);
    }

    /**
     * OrderExpiration
     * Description: Returns expiration date of the selected pending order.
     * URL: http://docs.mql4.com/trading/orderexpiration.html
     *
     * @throws Exception
     */
    public Date OrderExpiration() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.OrderExpiration_1, parameters); // MQLCommand ENUM = 114
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (Date) getCommandManager().getCommandResult(id);
    }

    /**
     * OrderLots
     * Description: Returns amount of lots of the selected order.
     * URL: http://docs.mql4.com/trading/orderlots.html
     *
     * @throws Exception
     */
    public double OrderLots() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.OrderLots_1, parameters); // MQLCommand ENUM = 115
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (double) getCommandManager().getCommandResult(id);
    }

    /**
     * OrderMagicNumber
     * Description: Returns an identifying (magic) number of the currently selected order.
     * URL: http://docs.mql4.com/trading/ordermagicnumber.html
     *
     * @throws Exception
     */
    public int OrderMagicNumber() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.OrderMagicNumber_1, parameters); // MQLCommand ENUM = 116
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (int) getCommandManager().getCommandResult(id);
    }

    /**
     * OrderModify
     * Description: Modification of characteristics of the previously opened or pending orders.
     * URL: http://docs.mql4.com/trading/ordermodify.html
     *
     * @param ticket      [in] Unique number of the order ticket.
     * @param price       [in] New open price of the pending order.
     * @param stoploss    [in] New StopLoss level.
     * @param takeprofit  [in] New TakeProfit level.
     * @param expiration  [in] Pending order expiration time.
     * @param arrow_color [in] Arrow color for StopLoss/TakeProfit modifications in the chart. If the parameter is missing or has CLR_NONE value, the arrows will not be shown in the chart.
     * @throws Exception
     */
    public boolean OrderModify(int ticket, double price, double stoploss, double takeprofit, Date expiration, COLOR arrow_color) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(ticket);
        parameters.add(price);
        parameters.add(stoploss);
        parameters.add(takeprofit);
        parameters.add(expiration);
        parameters.add(arrow_color);
        int id = getCommandManager().execCommand(MQLCommand.OrderModify_1, parameters); // MQLCommand ENUM = 117
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (boolean) getCommandManager().getCommandResult(id);
    }

    /**
     * OrderOpenPrice
     * Description: Returns open price of the currently selected order.
     * URL: http://docs.mql4.com/trading/orderopenprice.html
     *
     * @throws Exception
     */
    public double OrderOpenPrice() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.OrderOpenPrice_1, parameters); // MQLCommand ENUM = 118
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (double) getCommandManager().getCommandResult(id);
    }

    /**
     * OrderOpenTime
     * Description: Returns open time of the currently selected order.
     * URL: http://docs.mql4.com/trading/orderopentime.html
     *
     * @throws Exception
     */
    public Date OrderOpenTime() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.OrderOpenTime_1, parameters); // MQLCommand ENUM = 119
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (Date) getCommandManager().getCommandResult(id);
    }

    /**
     * OrderPrint
     * Description: Prints information about the selected order in the log.
     * URL: http://docs.mql4.com/trading/orderprint.html
     *
     * @throws Exception
     */
    public void OrderPrint() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.OrderPrint_1, parameters); // MQLCommand ENUM = 120
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
    }

    /**
     * OrderProfit
     * Description: Returns profit of the currently selected order.
     * URL: http://docs.mql4.com/trading/orderprofit.html
     *
     * @throws Exception
     */
    public double OrderProfit() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.OrderProfit_1, parameters); // MQLCommand ENUM = 121
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (double) getCommandManager().getCommandResult(id);
    }

    /**
     * OrderSelect
     * Description: The function selects an order for further processing.
     * URL: http://docs.mql4.com/trading/orderselect.html
     *
     * @param index
     * @param select              [in] Selecting flags. It can be any of the following values:
     * @param pool">SELECT_BY_POS - index in the order pool, SELECT_BY_TICKET - index is order ticket.
     * @throws Exception
     */
    public boolean OrderSelect(int index, int select, int pool) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(index);
        parameters.add(select);
        parameters.add(pool);
        int id = getCommandManager().execCommand(MQLCommand.OrderSelect_1, parameters); // MQLCommand ENUM = 122
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (boolean) getCommandManager().getCommandResult(id);
    }

    /**
     * OrderSend
     * Description: The main function used to open market or place a pending order.
     * URL: http://docs.mql4.com/trading/ordersend.html
     *
     * @param symbol      [in] Symbol for trading.
     * @param cmd         [in] Operation type. It can be any of the enumeration.
     * @param volume      [in] Number of lots.
     * @param price       [in] Order price.
     * @param slippage    [in] Maximum price slippage for buy or sell orders.
     * @param stoploss    [in] Stop loss level.
     * @param takeprofit  [in] Take profit level.
     * @param comment     [in] Order comment text. Last part of the comment may be changed by server.
     * @param magic       [in] Order magic number. May be used as user defined identifier.
     * @param expiration  [in] Order expiration time (for pending orders only).
     * @param arrow_color [in] Color of the opening arrow on the chart. If parameter is missing or has CLR_NONE value opening arrow is not drawn on the chart.
     * @throws Exception
     */
    public int OrderSend(String symbol, int cmd, double volume, double price, int slippage, double stoploss, double takeprofit, String comment, int magic, Date expiration, COLOR arrow_color) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(symbol);
        parameters.add(cmd);
        parameters.add(volume);
        parameters.add(price);
        parameters.add(slippage);
        parameters.add(stoploss);
        parameters.add(takeprofit);
        parameters.add(comment);
        parameters.add(magic);
        parameters.add(expiration);
        parameters.add(arrow_color);
        int id = getCommandManager().execCommand(MQLCommand.OrderSend_1, parameters); // MQLCommand ENUM = 123
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (int) getCommandManager().getCommandResult(id);
    }

    /**
     * OrdersHistoryTotal
     * Description: Returns the number of closed orders in the account history loaded into the terminal.
     * URL: http://docs.mql4.com/trading/ordershistorytotal.html
     *
     * @throws Exception
     */
    public int OrdersHistoryTotal() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.OrdersHistoryTotal_1, parameters); // MQLCommand ENUM = 124
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (int) getCommandManager().getCommandResult(id);
    }

    /**
     * OrderStopLoss
     * Description: Returns stop loss value of the currently selected order.
     * URL: http://docs.mql4.com/trading/orderstoploss.html
     *
     * @throws Exception
     */
    public double OrderStopLoss() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.OrderStopLoss_1, parameters); // MQLCommand ENUM = 125
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (double) getCommandManager().getCommandResult(id);
    }

    /**
     * OrdersTotal
     * Description: Returns the number of market and pending orders.
     * URL: http://docs.mql4.com/trading/orderstotal.html
     *
     * @throws Exception
     */
    public int OrdersTotal() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.OrdersTotal_1, parameters); // MQLCommand ENUM = 126
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (int) getCommandManager().getCommandResult(id);
    }

    /**
     * OrderSwap
     * Description: Returns swap value of the currently selected order.
     * URL: http://docs.mql4.com/trading/orderswap.html
     *
     * @throws Exception
     */
    public double OrderSwap() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.OrderSwap_1, parameters); // MQLCommand ENUM = 127
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (double) getCommandManager().getCommandResult(id);
    }

    /**
     * OrderSymbol
     * Description: Returns symbol name of the currently selected order.
     * URL: http://docs.mql4.com/trading/ordersymbol.html
     *
     * @throws Exception
     */
    public String OrderSymbol() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.OrderSymbol_1, parameters); // MQLCommand ENUM = 128
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (String) getCommandManager().getCommandResult(id);
    }

    /**
     * OrderTakeProfit
     * Description: Returns take profit value of the currently selected order.
     * URL: http://docs.mql4.com/trading/ordertakeprofit.html
     *
     * @throws Exception
     */
    public double OrderTakeProfit() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.OrderTakeProfit_1, parameters); // MQLCommand ENUM = 129
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (double) getCommandManager().getCommandResult(id);
    }

    /**
     * OrderTicket
     * Description: Returns ticket number of the currently selected order.
     * URL: http://docs.mql4.com/trading/orderticket.html
     *
     * @throws Exception
     */
    public int OrderTicket() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.OrderTicket_1, parameters); // MQLCommand ENUM = 130
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (int) getCommandManager().getCommandResult(id);
    }

    /**
     * OrderType
     * Description: Returns order operation type of the currently selected order.
     * URL: http://docs.mql4.com/trading/ordertype.html
     *
     * @throws Exception
     */
    public int OrderType() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.OrderType_1, parameters); // MQLCommand ENUM = 131
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (int) getCommandManager().getCommandResult(id);
    }

    /**
     * SignalBaseGetDouble
     * Description: Returns the value of
     * URL: http://docs.mql4.com/signals/signalbasegetdouble.html
     *
     * @param property_id [in] Signal property identifier. The value can be one of the values of the enumeration.
     * @throws Exception
     */
    public double SignalBaseGetDouble(SIGNAL_BASE_DOUBLE property_id) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(property_id.toString());
        int id = getCommandManager().execCommand(MQLCommand.SignalBaseGetDouble_1, parameters); // MQLCommand ENUM = 132
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (double) getCommandManager().getCommandResult(id);
    }

    /**
     * SignalBaseGetInteger
     * Description: Returns the value of
     * URL: http://docs.mql4.com/signals/signalbasegetinteger.html
     *
     * @param property_id [in] Signal property identifier. The value can be one of the values of the enumeration.
     * @throws Exception
     */
    public long SignalBaseGetInteger(SIGNAL_BASE_INTEGER property_id) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(property_id.toString());
        int id = getCommandManager().execCommand(MQLCommand.SignalBaseGetInteger_1, parameters); // MQLCommand ENUM = 133
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (long) getCommandManager().getCommandResult(id);
    }

    /**
     * SignalBaseGetString
     * Description: Returns the value of
     * URL: http://docs.mql4.com/signals/signalbasegetString.html
     *
     * @param property_id [in] Signal property identifier. The value can be one of the values of the enumeration.
     * @throws Exception
     */
    public String SignalBaseGetString(SIGNAL_BASE_STRING property_id) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(property_id.toString());
        int id = getCommandManager().execCommand(MQLCommand.SignalBaseGetString_1, parameters); // MQLCommand ENUM = 134
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (String) getCommandManager().getCommandResult(id);
    }

    /**
     * SignalBaseSelect
     * Description: Selects a signal from signals, available in terminal for further working with it.
     * URL: http://docs.mql4.com/signals/signalbaseselect.html
     *
     * @param index [in] Signal index in base of trading signals.
     * @throws Exception
     */
    public boolean SignalBaseSelect(int index) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(index);
        int id = getCommandManager().execCommand(MQLCommand.SignalBaseSelect_1, parameters); // MQLCommand ENUM = 135
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (boolean) getCommandManager().getCommandResult(id);
    }

    /**
     * SignalBaseTotal
     * Description: Returns the total amount of signals, available in terminal.
     * URL: http://docs.mql4.com/signals/signalbasetotal.html
     *
     * @throws Exception
     */
    public int SignalBaseTotal() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.SignalBaseTotal_1, parameters); // MQLCommand ENUM = 136
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (int) getCommandManager().getCommandResult(id);
    }

    /**
     * SignalInfoGetDouble
     * Description: Returns the value of
     * URL: http://docs.mql4.com/signals/signalinfogetdouble.html
     *
     * @param property_id [in] Signal copy settings property identifier. The value can be one of the values of the enumeration.
     * @throws Exception
     */
    public double SignalInfoGetDouble(SIGNAL_INFO_DOUBLE property_id) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(property_id.toString());
        int id = getCommandManager().execCommand(MQLCommand.SignalInfoGetDouble_1, parameters); // MQLCommand ENUM = 137
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (double) getCommandManager().getCommandResult(id);
    }

    /**
     * SignalInfoGetInteger
     * Description: Returns the value of
     * URL: http://docs.mql4.com/signals/signalinfogetinteger.html
     *
     * @param property_id [in] Signal copy settings property identifier. The value can be one of the values of the enumeration.
     * @throws Exception
     */
    public long SignalInfoGetInteger(SIGNAL_INFO_INTEGER property_id) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(property_id.toString());
        int id = getCommandManager().execCommand(MQLCommand.SignalInfoGetInteger_1, parameters); // MQLCommand ENUM = 138
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (long) getCommandManager().getCommandResult(id);
    }

    /**
     * SignalInfoGetString
     * Description: Returns the value of
     * URL: http://docs.mql4.com/signals/signalinfogetString.html
     *
     * @param property_id [in] Signal copy settings property identifier. The value can be one of the values of the enumeration.
     * @throws Exception
     */
    public String SignalInfoGetString(SIGNAL_INFO_STRING property_id) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(property_id.toString());
        int id = getCommandManager().execCommand(MQLCommand.SignalInfoGetString_1, parameters); // MQLCommand ENUM = 139
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (String) getCommandManager().getCommandResult(id);
    }

    /**
     * SignalInfoSetDouble
     * Description: Sets the value of
     * URL: http://docs.mql4.com/signals/signalinfosetdouble.html
     *
     * @param property_id [in] Signal copy settings property identifier. The value can be one of the values of the enumeration.
     * @param value       [in] The value of signal copy settings property.
     * @throws Exception
     */
    public boolean SignalInfoSetDouble(SIGNAL_INFO_DOUBLE property_id, double value) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(property_id.toString());
        parameters.add(value);
        int id = getCommandManager().execCommand(MQLCommand.SignalInfoSetDouble_1, parameters); // MQLCommand ENUM = 140
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (boolean) getCommandManager().getCommandResult(id);
    }

    /**
     * SignalInfoSetInteger
     * Description: Sets the value of
     * URL: http://docs.mql4.com/signals/signalinfosetinteger.html
     *
     * @param property_id [in] Signal copy settings property identifier. The value can be one of the values of the enumeration.
     * @param value       [in] The value of signal copy settings property.
     * @throws Exception
     */
    public boolean SignalInfoSetInteger(SIGNAL_INFO_INTEGER property_id, long value) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(property_id.toString());
        parameters.add(value);
        int id = getCommandManager().execCommand(MQLCommand.SignalInfoSetInteger_1, parameters); // MQLCommand ENUM = 141
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (boolean) getCommandManager().getCommandResult(id);
    }

    /**
     * SignalSubscribe
     * Description: Subscribes to the trading signal.
     * URL: http://docs.mql4.com/signals/signalsubscribe.html
     *
     * @param signal_id [in] Signal identifier.
     * @throws Exception
     */
    public boolean SignalSubscribe(long signal_id) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(signal_id);
        int id = getCommandManager().execCommand(MQLCommand.SignalSubscribe_1, parameters); // MQLCommand ENUM = 142
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (boolean) getCommandManager().getCommandResult(id);
    }

    /**
     * SignalUnsubscribe
     * Description: Cancels subscription.
     * URL: http://docs.mql4.com/signals/signalunsubscribe.html
     *
     * @throws Exception
     */
    public boolean SignalUnsubscribe() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.SignalUnsubscribe_1, parameters); // MQLCommand ENUM = 143
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (boolean) getCommandManager().getCommandResult(id);
    }

    /**
     * GlobalVariableCheck
     * Description: Checks the existence of a global variable with the specified name
     * URL: http://docs.mql4.com/globals/globalvariablecheck.html
     *
     * @param name [in] Global variable name.
     * @throws Exception
     */
    public boolean GlobalVariableCheck(String name) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(name);
        int id = getCommandManager().execCommand(MQLCommand.GlobalVariableCheck_1, parameters); // MQLCommand ENUM = 144
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (boolean) getCommandManager().getCommandResult(id);
    }

    /**
     * GlobalVariableTime
     * Description: Returns the time when the global variable was last accessed.
     * URL: http://docs.mql4.com/globals/globalvariabletime.html
     *
     * @param name [in] Name of the global variable.
     * @throws Exception
     */
    public Date GlobalVariableTime(String name) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(name);
        int id = getCommandManager().execCommand(MQLCommand.GlobalVariableTime_1, parameters); // MQLCommand ENUM = 145
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (Date) getCommandManager().getCommandResult(id);
    }

    /**
     * GlobalVariableDel
     * Description: Deletes a global variable from the client terminal
     * URL: http://docs.mql4.com/globals/globalvariabledel.html
     *
     * @param name [in] Global variable name.
     * @throws Exception
     */
    public boolean GlobalVariableDel(String name) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(name);
        int id = getCommandManager().execCommand(MQLCommand.GlobalVariableDel_1, parameters); // MQLCommand ENUM = 146
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (boolean) getCommandManager().getCommandResult(id);
    }

    /**
     * GlobalVariableGet
     * Description: Returns the value of an existing global variable of the client terminal. There are 2 variants of the function.
     * URL: http://docs.mql4.com/globals/globalvariableget.html
     *
     * @param name [in] Global variable name.
     * @throws Exception
     */
    public double GlobalVariableGet(String name) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(name);
        int id = getCommandManager().execCommand(MQLCommand.GlobalVariableGet_1, parameters); // MQLCommand ENUM = 147
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (double) getCommandManager().getCommandResult(id);
    }

    /**
     * GlobalVariableName
     * Description: Returns the name of a global variable by its ordinal number.
     * URL: http://docs.mql4.com/globals/globalvariablename.html
     *
     * @param index [in] Sequence number in the list of global variables. It should be greater than or equal to 0 and less than .
     * @throws Exception
     */
    public String GlobalVariableName(int index) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(index);
        int id = getCommandManager().execCommand(MQLCommand.GlobalVariableName_1, parameters); // MQLCommand ENUM = 148
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (String) getCommandManager().getCommandResult(id);
    }

    /**
     * GlobalVariableSet
     * Description: Sets a new value for a global variable. If the variable does not exist, the system creates a new global variable.
     * URL: http://docs.mql4.com/globals/globalvariableset.html
     *
     * @param name  [in] Global variable name.
     * @param value [in] The new numerical value.
     * @throws Exception
     */
    public Date GlobalVariableSet(String name, double value) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(name);
        parameters.add(value);
        int id = getCommandManager().execCommand(MQLCommand.GlobalVariableSet_1, parameters); // MQLCommand ENUM = 149
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (Date) getCommandManager().getCommandResult(id);
    }

    /**
     * GlobalVariablesFlush
     * Description: Forcibly saves contents of all global variables to a disk.
     * URL: http://docs.mql4.com/globals/globalvariablesflush.html
     *
     * @throws Exception
     */
    public void GlobalVariablesFlush() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.GlobalVariablesFlush_1, parameters); // MQLCommand ENUM = 150
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
    }

    /**
     * GlobalVariableTemp
     * Description: The function attempts to create a temporary global variable. If the variable doesn't exist, the system creates a new temporary global variable.
     * URL: http://docs.mql4.com/globals/globalvariabletemp.html
     *
     * @param name [in] The name of a temporary global variable.
     * @throws Exception
     */
    public boolean GlobalVariableTemp(String name) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(name);
        int id = getCommandManager().execCommand(MQLCommand.GlobalVariableTemp_1, parameters); // MQLCommand ENUM = 151
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (boolean) getCommandManager().getCommandResult(id);
    }

    /**
     * GlobalVariableSetOnCondition
     * Description: Sets the new value of the existing global variable if the current value equals to the third parameter check_value. If there is no global variable, the function will generate an error ERR_GLOBALVARIABLE_NOT_FOUND (4501) and return false.
     * URL: http://docs.mql4.com/globals/globalvariablesetoncondition.html
     *
     * @param name        [in] The name of a global variable.
     * @param value       [in] New value.
     * @param check_value [in] The value to check the current value of the global variable.
     * @throws Exception
     */
    public boolean GlobalVariableSetOnCondition(String name, double value, double check_value) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(name);
        parameters.add(value);
        parameters.add(check_value);
        int id = getCommandManager().execCommand(MQLCommand.GlobalVariableSetOnCondition_1, parameters); // MQLCommand ENUM = 152
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (boolean) getCommandManager().getCommandResult(id);
    }

    /**
     * GlobalVariablesDeleteAll
     * Description: Deletes global variables of the client terminal.
     * URL: http://docs.mql4.com/globals/globalvariablesdeleteall.html
     *
     * @param prefix_name [in] Name prefix global variables to remove. If you specify a prefix NULL or empty String, then all variables that meet the data criterion will be deleted.
     * @param limit_data  [in] Optional parameter. Date to select global variables by the time of their last modification. The function removes global variables, which were changed before this date. If the parameter is zero, then all variables that meet the first criterion (prefix) are deleted.
     * @throws Exception
     */
    public int GlobalVariablesDeleteAll(String prefix_name, Date limit_data) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(prefix_name);
        parameters.add(limit_data);
        int id = getCommandManager().execCommand(MQLCommand.GlobalVariablesDeleteAll_1, parameters); // MQLCommand ENUM = 153
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (int) getCommandManager().getCommandResult(id);
    }

    /**
     * GlobalVariablesTotal
     * Description: Returns the total number of global variables of the client terminal.
     * URL: http://docs.mql4.com/globals/globalvariablestotal.html
     *
     * @throws Exception
     */
    public int GlobalVariablesTotal() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.GlobalVariablesTotal_1, parameters); // MQLCommand ENUM = 154
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (int) getCommandManager().getCommandResult(id);
    }

    /**
     * HideTestIndicators
     * Description: The function sets a flag hiding indicators called by the Expert Advisor.
     * URL: http://docs.mql4.com/customind/hidetestindicators.html
     *
     * @param hide [in] Hiding flag.
     * @throws Exception
     */
    public void HideTestIndicators(boolean hide) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(hide);
        int id = getCommandManager().execCommand(MQLCommand.HideTestIndicators_1, parameters); // MQLCommand ENUM = 155
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
    }

    /**
     * IndicatorSetDouble
     * Description: The function sets the value of the corresponding indicator property. Indicator property must be of the double type. There are two variants of the function.
     * URL: http://docs.mql4.com/customind/indicatorsetdouble.html
     *
     * @param prop_id    [in] Identifier of the indicator property. The value can be one of the values of the enumeration.
     * @param prop_value [in] Value of property.
     * @throws Exception
     */
    public boolean IndicatorSetDouble(int prop_id, double prop_value) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(prop_id);
        parameters.add(prop_value);
        int id = getCommandManager().execCommand(MQLCommand.IndicatorSetDouble_1, parameters); // MQLCommand ENUM = 156
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (boolean) getCommandManager().getCommandResult(id);
    }

    /**
     * IndicatorSetDouble
     * Description: The function sets the value of the corresponding indicator property. Indicator property must be of the double type. There are two variants of the function.
     * URL: http://docs.mql4.com/customind/indicatorsetdouble.html
     *
     * @param prop_id       [in] Identifier of the indicator property. The value can be one of the values of the enumeration.
     * @param prop_modifier [in] Modifier of the specified property. Only level properties require a modifier. Numbering of levels starts from 0. It means that in order to set property for the second level you need to specify 1 (1 less than when using ).
     * @param prop_value    [in] Value of property.
     * @throws Exception
     */
    public boolean IndicatorSetDouble(int prop_id, int prop_modifier, double prop_value) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(prop_id);
        parameters.add(prop_modifier);
        parameters.add(prop_value);
        int id = getCommandManager().execCommand(MQLCommand.IndicatorSetDouble_2, parameters); // MQLCommand ENUM = 156
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (boolean) getCommandManager().getCommandResult(id);
    }

    /**
     * IndicatorSetInteger
     * Description: The function sets the value of the corresponding indicator property. Indicator property must be of the int or color type. There are two variants of the function.
     * URL: http://docs.mql4.com/customind/indicatorsetinteger.html
     *
     * @param prop_id    [in] Identifier of the indicator property. The value can be one of the values of the enumeration.
     * @param prop_value [in] Value of property.
     * @throws Exception
     */
    public boolean IndicatorSetInteger(int prop_id, int prop_value) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(prop_id);
        parameters.add(prop_value);
        int id = getCommandManager().execCommand(MQLCommand.IndicatorSetInteger_1, parameters); // MQLCommand ENUM = 157
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (boolean) getCommandManager().getCommandResult(id);
    }

    /**
     * IndicatorSetInteger
     * Description: The function sets the value of the corresponding indicator property. Indicator property must be of the int or color type. There are two variants of the function.
     * URL: http://docs.mql4.com/customind/indicatorsetinteger.html
     *
     * @param prop_id       [in] Identifier of the indicator property. The value can be one of the values of the enumeration.
     * @param prop_modifier [in] Modifier of the specified property. Only level properties require a modifier.
     * @param prop_value    [in] Value of property.
     * @throws Exception
     */
    public boolean IndicatorSetInteger(int prop_id, int prop_modifier, int prop_value) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(prop_id);
        parameters.add(prop_modifier);
        parameters.add(prop_value);
        int id = getCommandManager().execCommand(MQLCommand.IndicatorSetInteger_2, parameters); // MQLCommand ENUM = 157
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (boolean) getCommandManager().getCommandResult(id);
    }

    /**
     * IndicatorSetString
     * Description: The function sets the value of the corresponding indicator property. Indicator property must be of the String type. There are two variants of the function.
     * URL: http://docs.mql4.com/customind/indicatorsetString.html
     *
     * @param prop_id    [in] Identifier of the indicator property. The value can be one of the values of the enumeration.
     * @param prop_value [in] Value of property.
     * @throws Exception
     */
    public boolean IndicatorSetString(int prop_id, String prop_value) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(prop_id);
        parameters.add(prop_value);
        int id = getCommandManager().execCommand(MQLCommand.IndicatorSetString_1, parameters); // MQLCommand ENUM = 158
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (boolean) getCommandManager().getCommandResult(id);
    }

    /**
     * IndicatorSetString
     * Description: The function sets the value of the corresponding indicator property. Indicator property must be of the String type. There are two variants of the function.
     * URL: http://docs.mql4.com/customind/indicatorsetString.html
     *
     * @param prop_id       [in] Identifier of the indicator property. The value can be one of the values of the enumeration.
     * @param prop_modifier [in] Modifier of the specified property. Only level properties require a modifier.
     * @param prop_value    [in] Value of property.
     * @throws Exception
     */
    public boolean IndicatorSetString(int prop_id, int prop_modifier, String prop_value) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(prop_id);
        parameters.add(prop_modifier);
        parameters.add(prop_value);
        int id = getCommandManager().execCommand(MQLCommand.IndicatorSetString_2, parameters); // MQLCommand ENUM = 158
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (boolean) getCommandManager().getCommandResult(id);
    }

    /**
     * IndicatorBuffers
     * Description: Allocates memory for buffers used for custom indicator calculations.
     * URL: http://docs.mql4.com/customind/indicatorbuffers.html
     *
     * @param count [in] Amount of buffers to be allocated. Should be within the range between indicator_buffers and 512 buffers.
     * @throws Exception
     */
    public boolean IndicatorBuffers(int count) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(count);
        int id = getCommandManager().execCommand(MQLCommand.IndicatorBuffers_1, parameters); // MQLCommand ENUM = 159
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (boolean) getCommandManager().getCommandResult(id);
    }

    /**
     * IndicatorCounted
     * Description: The function returns the amount of bars not changed after the indicator had been launched last.
     * URL: http://docs.mql4.com/customind/indicatorcounted.html
     *
     * @throws Exception
     */
    public int IndicatorCounted() throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        int id = getCommandManager().execCommand(MQLCommand.IndicatorCounted_1, parameters); // MQLCommand ENUM = 160
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (int) getCommandManager().getCommandResult(id);
    }

    /**
     * IndicatorDigits
     * Description: Sets precision format (the count of digits after decimal point) to visualize indicator values.
     * URL: http://docs.mql4.com/customind/indicatordigits.html
     *
     * @param digits [in] Precision format, the count of digits after decimal point.
     * @throws Exception
     */
    public void IndicatorDigits(int digits) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(digits);
        int id = getCommandManager().execCommand(MQLCommand.IndicatorDigits_1, parameters); // MQLCommand ENUM = 161
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
    }

    /**
     * IndicatorShortName
     * Description: Sets the "short" name of a custom indicator to be shown in the DataWindow and in the chart subwindow.
     * URL: http://docs.mql4.com/customind/indicatorshortname.html
     *
     * @param name [in] New short name.
     * @throws Exception
     */
    public void IndicatorShortName(String name) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(name);
        int id = getCommandManager().execCommand(MQLCommand.IndicatorShortName_1, parameters); // MQLCommand ENUM = 162
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
    }

    /**
     * SetIndexArrow
     * Description: Sets an arrow symbol for indicators line of the DRAW_ARROW type.
     * URL: http://docs.mql4.com/customind/setindexarrow.html
     *
     * @param index [in] Line index. Must lie between 0 and 7.
     * @param code  [in] Symbol code from or predefined .
     * @throws Exception
     */
    public void SetIndexArrow(int index, int code) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(index);
        parameters.add(code);
        int id = getCommandManager().execCommand(MQLCommand.SetIndexArrow_1, parameters); // MQLCommand ENUM = 163
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
    }

    /**
     * SetIndexDrawBegin
     * Description: Sets the bar number (from the data beginning) from which the drawing of the given indicator line must start.
     * URL: http://docs.mql4.com/customind/setindexdrawbegin.html
     *
     * @param index [in] Line index. Must lie between 0 and 7.
     * @param begin [in] First drawing bar position number.
     * @throws Exception
     */
    public void SetIndexDrawBegin(int index, int begin) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(index);
        parameters.add(begin);
        int id = getCommandManager().execCommand(MQLCommand.SetIndexDrawBegin_1, parameters); // MQLCommand ENUM = 164
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
    }

    /**
     * SetIndexEmptyValue
     * Description: Sets drawing line empty value.
     * URL: http://docs.mql4.com/customind/setindexemptyvalue.html
     *
     * @param index [in] Line index. Must lie between 0 and 7.
     * @param value [in] New "empty" value.
     * @throws Exception
     */
    public void SetIndexEmptyValue(int index, double value) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(index);
        parameters.add(value);
        int id = getCommandManager().execCommand(MQLCommand.SetIndexEmptyValue_1, parameters); // MQLCommand ENUM = 165
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
    }

    /**
     * SetIndexLabel
     * Description: Sets drawing line description for showing in the DataWindow and in the tooltip.
     * URL: http://docs.mql4.com/customind/setindexlabel.html
     *
     * @param index [in] Line index. Must lie between 0 and 7.
     * @param text  [in] Label text. NULL means that index value is not shown in the DataWindow.
     * @throws Exception
     */
    public void SetIndexLabel(int index, String text) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(index);
        parameters.add(text);
        int id = getCommandManager().execCommand(MQLCommand.SetIndexLabel_1, parameters); // MQLCommand ENUM = 166
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
    }

    /**
     * SetIndexShift
     * Description: Sets offset for the drawing line.
     * URL: http://docs.mql4.com/customind/setindexshift.html
     *
     * @param index [in] Line index. Must lie between 0 and 7.
     * @param shift [in] Shift value in bars.
     * @throws Exception
     */
    public void SetIndexShift(int index, int shift) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(index);
        parameters.add(shift);
        int id = getCommandManager().execCommand(MQLCommand.SetIndexShift_1, parameters); // MQLCommand ENUM = 167
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
    }

    /**
     * SetIndexStyle
     * Description: Sets the new type, style, width and color for a given indicator line.
     * URL: http://docs.mql4.com/customind/setindexstyle.html
     *
     * @param index [in] Line index. Must lie between 0 and 7.
     * @param type  [in] Shape style. Can be one of listed.
     * @param style [in] Drawing style. It is used for one-pixel thick lines. It can be one of the listed. EMPTY value means that the style will not be changed.
     * @param width [in] Line width. Valid values are: 1,2,3,4,5. EMPTY value means that width will not be changed.
     * @param clr   [in] Line color. Absence of this parameter means that the color will not be changed.
     * @throws Exception
     */
    public void SetIndexStyle(int index, int type, int style, int width, COLOR clr) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(index);
        parameters.add(type);
        parameters.add(style);
        parameters.add(width);
        parameters.add(clr);
        int id = getCommandManager().execCommand(MQLCommand.SetIndexStyle_1, parameters); // MQLCommand ENUM = 168
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
    }

    /**
     * SetLevelStyle
     * Description: The function sets a new style, width and color of horizontal levels of indicator to be output in a separate window.
     * URL: http://docs.mql4.com/customind/setlevelstyle.html
     *
     * @param draw_style [in] Drawing style. Can be one of the listed. EMPTY value means that the style will not be changed.
     * @param line_width [in] Line width. Valid values are 1,2,3,4,5. EMPTY value indicates that the width will not be changed.
     * @param clr        [in] Line color. Empty value CLR_NONE means that the color will not be changed.
     * @throws Exception
     */
    public void SetLevelStyle(int draw_style, int line_width, COLOR clr) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(draw_style);
        parameters.add(line_width);
        parameters.add(clr);
        int id = getCommandManager().execCommand(MQLCommand.SetLevelStyle_1, parameters); // MQLCommand ENUM = 169
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
    }

    /**
     * SetLevelValue
     * Description: The function sets a value for a given horizontal level of the indicator to be output in a separate window.
     * URL: http://docs.mql4.com/customind/setlevelvalue.html
     *
     * @param level [in] Level index (0-31).
     * @param value [in] Value for the given indicator level.
     * @throws Exception
     */
    public void SetLevelValue(int level, double value) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(level);
        parameters.add(value);
        int id = getCommandManager().execCommand(MQLCommand.SetLevelValue_1, parameters); // MQLCommand ENUM = 170
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
    }


    /**
     * ObjectCreate
     * Description: The function creates an object with the specified name, type, and the initial coordinates in the specified chart subwindow of the specified chart. There are two variants of the function:
     * URL: http://docs.mql4.com/objects/objectcreate.html
     *
     * @param chart_id    [in] Chart identifier.
     * @param object_name [in] Name of the object. The name must be unique within a chart, including its subwindows.
     * @param object_type [in] Object type. The value can be one of the values of the enumeration.
     * @param sub_window  [in] Number of the chart subwindow. 0 means the main chart window. The specified subwindow must exist (window index must be greater or equal to 0 and less than ), otherwise the function returns false.
     * @param time1       [in] The time coordinate of the first anchor point.
     * @param price1      [in] The price coordinate of the first anchor point.
     * @param timeN       [in] The time coordinate of the N-th anchor point.
     * @param priceN      [in] The price coordinate of the N-th anchor point.
     * @throws Exception
     */
    public boolean ObjectCreate(long chart_id, String object_name, OBJECT_TYPE object_type, int sub_window, Date time1, double price1, Date timeN, double priceN) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(chart_id);
        parameters.add(object_name);
        parameters.add(object_type.toString());
        parameters.add(sub_window);
        parameters.add(time1);
        parameters.add(price1);
        parameters.add(timeN);
        parameters.add(priceN);
        int id = getCommandManager().execCommand(MQLCommand.ObjectCreate_1, parameters); // MQLCommand ENUM = 171
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (boolean) getCommandManager().getCommandResult(id);
    }

    /**
     * ObjectCreate
     * Description: The function creates an object with the specified name, type, and the initial coordinates in the specified chart subwindow of the specified chart. There are two variants of the function:
     * URL: http://docs.mql4.com/objects/objectcreate.html
     *
     * @param object_name [in] Name of the object. The name must be unique within a chart, including its subwindows.
     * @param object_type [in] Object type. The value can be one of the values of the enumeration.
     * @param sub_window  [in] Number of the chart subwindow. 0 means the main chart window. The specified subwindow must exist (window index must be greater or equal to 0 and less than ), otherwise the function returns false.
     * @param time1       [in] The time coordinate of the first anchor point.
     * @param price1      [in] The price coordinate of the first anchor point.
     * @param time2       [in] The time coordinate of the second anchor point.
     * @param price2      [in] The price coordinate of the second anchor point.
     * @param time3       [in] The time coordinate of the third anchor point.
     * @param price3      [in] The price coordinate of the third anchor point.
     * @throws Exception
     */
    public boolean ObjectCreate(String object_name, OBJECT_TYPE object_type, int sub_window, Date time1, double price1, Date time2, double price2, Date time3, double price3) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(object_name);
        parameters.add(object_type.toString());
        parameters.add(sub_window);
        parameters.add(time1);
        parameters.add(price1);
        parameters.add(time2);
        parameters.add(price2);
        parameters.add(time3);
        parameters.add(price3);
        int id = getCommandManager().execCommand(MQLCommand.ObjectCreate_2, parameters); // MQLCommand ENUM = 171
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (boolean) getCommandManager().getCommandResult(id);
    }

    /**
     * ObjectName
     * Description: The function returns the name of the corresponding object by its index in the objects list.
     * URL: http://docs.mql4.com/objects/objectname.html
     *
     * @param object_index [in] Object index. This value must be greater or equal to 0 and less than .
     * @throws Exception
     */
    public String ObjectName(int object_index) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(object_index);
        int id = getCommandManager().execCommand(MQLCommand.ObjectName_1, parameters); // MQLCommand ENUM = 172
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (String) getCommandManager().getCommandResult(id);
    }

    /**
     * ObjectDelete
     * Description: The function removes the object with the specified name at the specified chart. There are two variants of the function:
     * URL: http://docs.mql4.com/objects/objectdelete.html
     *
     * @param chart_id    [in] Chart identifier.
     * @param object_name [in] Name of object to be deleted.
     * @throws Exception
     */
    public boolean ObjectDelete(long chart_id, String object_name) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(chart_id);
        parameters.add(object_name);
        int id = getCommandManager().execCommand(MQLCommand.ObjectDelete_1, parameters); // MQLCommand ENUM = 173
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (boolean) getCommandManager().getCommandResult(id);
    }

    /**
     * ObjectDelete
     * Description: The function removes the object with the specified name at the specified chart. There are two variants of the function:
     * URL: http://docs.mql4.com/objects/objectdelete.html
     *
     * @param object_name [in] Name of object to be deleted.
     * @throws Exception
     */
    public boolean ObjectDelete(String object_name) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(object_name);
        int id = getCommandManager().execCommand(MQLCommand.ObjectDelete_2, parameters); // MQLCommand ENUM = 173
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (boolean) getCommandManager().getCommandResult(id);
    }

    /**
     * ObjectsDeleteAll
     * Description: Removes all objects from the specified chart, specified chart subwindow, of the specified type.
     * URL: http://docs.mql4.com/objects/objectsdeleteall.html
     *
     * @param chart_id    [in] Chart identifier.
     * @param sub_window  [in] Number of the chart window. Must be greater or equal to -1 (-1 mean all subwindows, 0 means the main chart window) and less than .
     * @param object_type [in] Type of the object. The value can be one of the values of the enumeration. EMPTY (-1) means all types.
     * @throws Exception
     */
    public int ObjectsDeleteAll(long chart_id, int sub_window, int object_type) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(chart_id);
        parameters.add(sub_window);
        parameters.add(object_type);
        int id = getCommandManager().execCommand(MQLCommand.ObjectsDeleteAll_1, parameters); // MQLCommand ENUM = 174
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (int) getCommandManager().getCommandResult(id);
    }

    /**
     * ObjectsDeleteAll
     * Description: Removes all objects from the specified chart, specified chart subwindow, of the specified type.
     * URL: http://docs.mql4.com/objects/objectsdeleteall.html
     *
     * @param sub_window  [in] Number of the chart window. Must be greater or equal to -1 (-1 mean all subwindows, 0 means the main chart window) and less than .
     * @param object_type [in] Type of the object. The value can be one of the values of the enumeration. EMPTY (-1) means all types.
     * @throws Exception
     */
    public int ObjectsDeleteAll(int sub_window, int object_type) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(sub_window);
        parameters.add(object_type);
        int id = getCommandManager().execCommand(MQLCommand.ObjectsDeleteAll_2, parameters); // MQLCommand ENUM = 174
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (int) getCommandManager().getCommandResult(id);
    }

    /**
     * ObjectsDeleteAll
     * Description: Removes all objects from the specified chart, specified chart subwindow, of the specified type.
     * URL: http://docs.mql4.com/objects/objectsdeleteall.html
     *
     * @param chart_id    [in] Chart identifier.
     * @param prefix      [in] Prefix in object names. All objects whose names start with this set of characters will be removed from chart. You can specify prefix as 'name' or 'name*' both variants will work the same. If an empty String is specified as the prefix, objects with all possible names will be removed.
     * @param sub_window  [in] Number of the chart window. Must be greater or equal to -1 (-1 mean all subwindows, 0 means the main chart window) and less than .
     * @param object_type [in] Type of the object. The value can be one of the values of the enumeration. EMPTY (-1) means all types.
     * @throws Exception
     */
    public int ObjectsDeleteAll(long chart_id, String prefix, int sub_window, int object_type) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(chart_id);
        parameters.add(prefix);
        parameters.add(sub_window);
        parameters.add(object_type);
        int id = getCommandManager().execCommand(MQLCommand.ObjectsDeleteAll_3, parameters); // MQLCommand ENUM = 174
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (int) getCommandManager().getCommandResult(id);
    }

    /**
     * ObjectFind
     * Description: The function searches for an object having the specified name. There are two variants of the function:
     * URL: http://docs.mql4.com/objects/objectfind.html
     *
     * @param chart_id    [in] Chart identifier.
     * @param object_name [in] The name of the object to find.
     * @throws Exception
     */
    public int ObjectFind(long chart_id, String object_name) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(chart_id);
        parameters.add(object_name);
        int id = getCommandManager().execCommand(MQLCommand.ObjectFind_1, parameters); // MQLCommand ENUM = 175
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (int) getCommandManager().getCommandResult(id);
    }

    /**
     * ObjectFind
     * Description: The function searches for an object having the specified name. There are two variants of the function:
     * URL: http://docs.mql4.com/objects/objectfind.html
     *
     * @param object_name [in] The name of the object to find.
     * @throws Exception
     */
    public int ObjectFind(String object_name) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(object_name);
        int id = getCommandManager().execCommand(MQLCommand.ObjectFind_2, parameters); // MQLCommand ENUM = 175
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (int) getCommandManager().getCommandResult(id);
    }

    /**
     * ObjectGetTimeByValue
     * Description: The function returns the time value for the specified price value of the specified object.
     * URL: http://docs.mql4.com/objects/objectgettimebyvalue.html
     *
     * @param object_name [in] Name of the object.
     * @param value       [in] Price value.
     * @param line_id     [in] Line identifier.
     * @throws Exception
     */
    public Date ObjectGetTimeByValue(String object_name, double value, int line_id) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(object_name);
        parameters.add(value);
        parameters.add(line_id);
        int id = getCommandManager().execCommand(MQLCommand.ObjectGetTimeByValue_1, parameters); // MQLCommand ENUM = 176
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (Date) getCommandManager().getCommandResult(id);
    }

    /**
     * ObjectGetValueByTime
     * Description: The function returns the price value for the specified time value of the specified object.
     * URL: http://docs.mql4.com/objects/objectgetvaluebytime.html
     *
     * @param chart_id    [in] Chart identifier.
     * @param object_name [in] Name of the object.
     * @param time        [in] Time value.
     * @param line_id     [in] Line identifier.
     * @throws Exception
     */
    public double ObjectGetValueByTime(long chart_id, String object_name, Date time, int line_id) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(chart_id);
        parameters.add(object_name);
        parameters.add(time);
        parameters.add(line_id);
        int id = getCommandManager().execCommand(MQLCommand.ObjectGetValueByTime_1, parameters); // MQLCommand ENUM = 177
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (double) getCommandManager().getCommandResult(id);
    }

    /**
     * ObjectMove
     * Description: The function changes coordinates of the specified anchor point of the object at the specified chart. There are two variants of the function:
     * URL: http://docs.mql4.com/objects/objectmove.html
     *
     * @param object_name [in] Name of the object.
     * @param point_index [in] Index of the anchor point. The number of anchor points depends on the .
     * @param time        [in] Time coordinate of the selected anchor point.
     * @param price       [in] Price coordinate of the selected anchor point.
     * @throws Exception
     */
    public boolean ObjectMove(String object_name, int point_index, Date time, double price) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(object_name);
        parameters.add(point_index);
        parameters.add(time);
        parameters.add(price);
        int id = getCommandManager().execCommand(MQLCommand.ObjectMove_1, parameters); // MQLCommand ENUM = 178
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (boolean) getCommandManager().getCommandResult(id);
    }

    /**
     * ObjectsTotal
     * Description: The function returns the number of objects of the specified type in the specified chart. There are two variants of the function:
     * URL: http://docs.mql4.com/objects/objectstotal.html
     *
     * @param chart_id   [in] Chart identifier.
     * @param sub_window [in] Number of the chart subwindow. 0 means the main chart window, -1 means all the subwindows of the chart, including the main window.
     * @param type       [in] Type of the object. The value can be one of the values of the enumeration. EMPTY(-1) means all types.
     * @throws Exception
     */
    public int ObjectsTotal(long chart_id, int sub_window, int type) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(chart_id);
        parameters.add(sub_window);
        parameters.add(type);
        int id = getCommandManager().execCommand(MQLCommand.ObjectsTotal_1, parameters); // MQLCommand ENUM = 179
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (int) getCommandManager().getCommandResult(id);
    }

    /**
     * ObjectsTotal
     * Description: The function returns the number of objects of the specified type in the specified chart. There are two variants of the function:
     * URL: http://docs.mql4.com/objects/objectstotal.html
     *
     * @param type [in] Type of the object. The value can be one of the values of the enumeration. EMPTY(-1) means all types.
     * @throws Exception
     */
    public int ObjectsTotal(int type) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(type);
        int id = getCommandManager().execCommand(MQLCommand.ObjectsTotal_2, parameters); // MQLCommand ENUM = 179
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (int) getCommandManager().getCommandResult(id);
    }

    /**
     * ObjectGetDouble
     * Description: The function returns the value of the corresponding object property. The object property must be of the
     * URL: http://docs.mql4.com/objects/objectgetdouble.html
     *
     * @param chart_id      [in] Chart identifier. 0 means the current chart.
     * @param object_name   [in] Name of the object.
     * @param prop_id       [in] ID of the object property. The value can be one of the values of the enumeration.
     * @param prop_modifier [in] Modifier of the specified property. For the first variant, the default modifier value is equal to 0. Most properties do not require a modifier. It denotes the number of the level in and in the graphical object Andrew's pitchfork. The numeration of levels starts from zero.
     * @throws Exception
     */
    public double ObjectGetDouble(long chart_id, String object_name, int prop_id, int prop_modifier) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(chart_id);
        parameters.add(object_name);
        parameters.add(prop_id);
        parameters.add(prop_modifier);
        int id = getCommandManager().execCommand(MQLCommand.ObjectGetDouble_1, parameters); // MQLCommand ENUM = 180
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (double) getCommandManager().getCommandResult(id);
    }

    /**
     * ObjectGetInteger
     * Description: The function returns the value of the corresponding object property. The object property must be of the
     * URL: http://docs.mql4.com/objects/objectgetinteger.html
     *
     * @param chart_id      [in] Chart identifier. 0 means the current chart.
     * @param object_name   [in] Name of the object.
     * @param prop_id       [in] ID of the object property. The value can be one of the values of the enumeration.
     * @param prop_modifier [in] Modifier of the specified property. For the first variant, the default modifier value is equal to 0. Most properties do not require a modifier. It denotes the number of the level in and in the graphical object Andrew's pitchfork. The numeration of levels starts from zero.
     * @throws Exception
     */
    public long ObjectGetInteger(long chart_id, String object_name, int prop_id, int prop_modifier) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(chart_id);
        parameters.add(object_name);
        parameters.add(prop_id);
        parameters.add(prop_modifier);
        int id = getCommandManager().execCommand(MQLCommand.ObjectGetInteger_1, parameters); // MQLCommand ENUM = 181
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (long) getCommandManager().getCommandResult(id);
    }

    /**
     * ObjectGetString
     * Description: The function returns the value of the corresponding object property. The object property must be of the
     * URL: http://docs.mql4.com/objects/objectgetString.html
     *
     * @param chart_id      [in] Chart identifier. 0 means the current chart.
     * @param object_name   [in] Name of the object.
     * @param prop_id       [in] ID of the object property. The value can be one of the values of the enumeration.
     * @param prop_modifier [in] Modifier of the specified property. For the first variant, the default modifier value is equal to 0. Most properties do not require a modifier. It denotes the number of the level in and in the graphical object Andrew's pitchfork. The numeration of levels starts from zero.
     * @throws Exception
     */
    public String ObjectGetString(long chart_id, String object_name, int prop_id, int prop_modifier) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(chart_id);
        parameters.add(object_name);
        parameters.add(prop_id);
        parameters.add(prop_modifier);
        int id = getCommandManager().execCommand(MQLCommand.ObjectGetString_1, parameters); // MQLCommand ENUM = 182
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (String) getCommandManager().getCommandResult(id);
    }

    /**
     * ObjectSetDouble
     * Description: The function sets the value of the corresponding object property. The object property must be of the
     * URL: http://docs.mql4.com/objects/objectsetdouble.html
     *
     * @param chart_id    [in] Chart identifier. 0 means the current chart.
     * @param object_name [in] Name of the object.
     * @param prop_id     [in] ID of the object property. The value can be one of the values of the enumeration.
     * @param prop_value  [in] The value of the property.
     * @throws Exception
     */
    public boolean ObjectSetDouble(long chart_id, String object_name, int prop_id, double prop_value) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(chart_id);
        parameters.add(object_name);
        parameters.add(prop_id);
        parameters.add(prop_value);
        int id = getCommandManager().execCommand(MQLCommand.ObjectSetDouble_1, parameters); // MQLCommand ENUM = 183
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (boolean) getCommandManager().getCommandResult(id);
    }

    /**
     * ObjectSetDouble
     * Description: The function sets the value of the corresponding object property. The object property must be of the
     * URL: http://docs.mql4.com/objects/objectsetdouble.html
     *
     * @param chart_id      [in] Chart identifier. 0 means the current chart.
     * @param object_name   [in] Name of the object.
     * @param prop_id       [in] ID of the object property. The value can be one of the values of the enumeration.
     * @param prop_modifier [in] Modifier of the specified property. It denotes the number of the level in and in the graphical object Andrew's pitchfork. The numeration of levels starts from zero.
     * @param prop_value    [in] The value of the property.
     * @throws Exception
     */
    public boolean ObjectSetDouble(long chart_id, String object_name, int prop_id, int prop_modifier, double prop_value) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(chart_id);
        parameters.add(object_name);
        parameters.add(prop_id);
        parameters.add(prop_modifier);
        parameters.add(prop_value);
        int id = getCommandManager().execCommand(MQLCommand.ObjectSetDouble_2, parameters); // MQLCommand ENUM = 183
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (boolean) getCommandManager().getCommandResult(id);
    }

    /**
     * ObjectSetInteger
     * Description: The function sets the value of the corresponding object property. The object property must be of the
     * URL: http://docs.mql4.com/objects/objectsetinteger.html
     *
     * @param chart_id    [in] Chart identifier. 0 means the current chart.
     * @param object_name [in] Name of the object.
     * @param prop_id     [in] ID of the object property. The value can be one of the values of the enumeration.
     * @param prop_value  [in] The value of the property.
     * @throws Exception
     */
    public boolean ObjectSetInteger(long chart_id, String object_name, int prop_id, long prop_value) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(chart_id);
        parameters.add(object_name);
        parameters.add(prop_id);
        parameters.add(prop_value);
        int id = getCommandManager().execCommand(MQLCommand.ObjectSetInteger_1, parameters); // MQLCommand ENUM = 184
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (boolean) getCommandManager().getCommandResult(id);
    }

    /**
     * ObjectSetInteger
     * Description: The function sets the value of the corresponding object property. The object property must be of the
     * URL: http://docs.mql4.com/objects/objectsetinteger.html
     *
     * @param chart_id      [in] Chart identifier. 0 means the current chart.
     * @param object_name   [in] Name of the object.
     * @param prop_id       [in] ID of the object property. The value can be one of the values of the enumeration.
     * @param prop_modifier [in] Modifier of the specified property. It denotes the number of the level in and in the graphical object Andrew's pitchfork. The numeration of levels starts from zero.
     * @param prop_value    [in] The value of the property.
     * @throws Exception
     */
    public boolean ObjectSetInteger(long chart_id, String object_name, int prop_id, int prop_modifier, long prop_value) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(chart_id);
        parameters.add(object_name);
        parameters.add(prop_id);
        parameters.add(prop_modifier);
        parameters.add(prop_value);
        int id = getCommandManager().execCommand(MQLCommand.ObjectSetInteger_2, parameters); // MQLCommand ENUM = 184
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (boolean) getCommandManager().getCommandResult(id);
    }

    /**
     * ObjectSetString
     * Description: The function sets the value of the corresponding object property. The object property must be of the
     * URL: http://docs.mql4.com/objects/objectsetString.html
     *
     * @param chart_id    [in] Chart identifier. 0 means the current chart.
     * @param object_name [in] Name of the object.
     * @param prop_id     [in] ID of the object property. The value can be one of the values of the enumeration.
     * @param prop_value  [in] The value of the property.
     * @throws Exception
     */
    public boolean ObjectSetString(long chart_id, String object_name, int prop_id, String prop_value) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(chart_id);
        parameters.add(object_name);
        parameters.add(prop_id);
        parameters.add(prop_value);
        int id = getCommandManager().execCommand(MQLCommand.ObjectSetString_1, parameters); // MQLCommand ENUM = 185
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (boolean) getCommandManager().getCommandResult(id);
    }

    /**
     * ObjectSetString
     * Description: The function sets the value of the corresponding object property. The object property must be of the
     * URL: http://docs.mql4.com/objects/objectsetString.html
     *
     * @param chart_id      [in] Chart identifier. 0 means the current chart.
     * @param object_name   [in] Name of the object.
     * @param prop_id       [in] ID of the object property. The value can be one of the values of the enumeration.
     * @param prop_modifier [in] Modifier of the specified property. It denotes the number of the level in and in the graphical object Andrew's pitchfork. The numeration of levels starts from zero.
     * @param prop_value    [in] The value of the property.
     * @throws Exception
     */
    public boolean ObjectSetString(long chart_id, String object_name, int prop_id, int prop_modifier, String prop_value) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(chart_id);
        parameters.add(object_name);
        parameters.add(prop_id);
        parameters.add(prop_modifier);
        parameters.add(prop_value);
        int id = getCommandManager().execCommand(MQLCommand.ObjectSetString_2, parameters); // MQLCommand ENUM = 185
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (boolean) getCommandManager().getCommandResult(id);
    }

    /**
     * TextSetFont
     * Description: The function sets the font for displaying the text using drawing methods and returns the result of that operation. Arial font with the size -120 (12 pt) is used by default.
     * URL: http://docs.mql4.com/objects/textsetfont.html
     *
     * @param name        [in] Font name in the system or the name of the resource containing the font or the path to font file on the disk.
     * @param size        [in] The font size that can be set using positive and negative values. In case of positive values, the size of a displayed text does not depend on the operating system's font size settings. In case of negative values, the value is set in tenths of a point and the text size depends on the operating system settings ("standard scale" or "large scale"). See the Note below for more information about the differences between the modes.
     * @param flags       [in] Combination of describing font style.
     * @param orientation [in] Text's horizontal inclination to X axis, the unit of measurement is 0.1 degrees. It means that orientation=450 stands for inclination equal to 45 degrees.
     * @throws Exception
     */
    public boolean TextSetFont(String name, int size, int flags, int orientation) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(name);
        parameters.add(size);
        parameters.add(flags);
        parameters.add(orientation);
        int id = getCommandManager().execCommand(MQLCommand.TextSetFont_1, parameters); // MQLCommand ENUM = 186
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (boolean) getCommandManager().getCommandResult(id);
    }

    /**
     * ObjectDescription
     * Description: Returns the object description.
     * URL: http://docs.mql4.com/objects/objectdescription.html
     *
     * @param object_name [in] Object name.
     * @throws Exception
     */
    public String ObjectDescription(String object_name) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(object_name);
        int id = getCommandManager().execCommand(MQLCommand.ObjectDescription_1, parameters); // MQLCommand ENUM = 187
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (String) getCommandManager().getCommandResult(id);
    }

    /**
     * ObjectGet
     * Description: Returns the value of the specified object property.
     * URL: http://docs.mql4.com/objects/objectget.html
     *
     * @param object_name [in] Object name.
     * @param index       [in] Object property index. It can be any of the enumeration values.
     * @throws Exception
     */
    public double ObjectGet(String object_name, int index) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(object_name);
        parameters.add(index);
        int id = getCommandManager().execCommand(MQLCommand.ObjectGet_1, parameters); // MQLCommand ENUM = 188
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (double) getCommandManager().getCommandResult(id);
    }

    /**
     * ObjectGetFiboDescription
     * Description: Returns the level description of a Fibonacci object.
     * URL: http://docs.mql4.com/objects/objectgetfibodescription.html
     *
     * @param object_name [in] Fibonacci object name.
     * @param index       [in] Index of the Fibonacci level (0-31).
     * @throws Exception
     */
    public String ObjectGetFiboDescription(String object_name, int index) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(object_name);
        parameters.add(index);
        int id = getCommandManager().execCommand(MQLCommand.ObjectGetFiboDescription_1, parameters); // MQLCommand ENUM = 189
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (String) getCommandManager().getCommandResult(id);
    }

    /**
     * ObjectGetShiftByValue
     * Description: The function calculates and returns bar index (shift related to the current bar) for the given price.
     * URL: http://docs.mql4.com/objects/objectgetshiftbyvalue.html
     *
     * @param object_name [in] Object name.
     * @param value       [in] Price value.
     * @throws Exception
     */
    public int ObjectGetShiftByValue(String object_name, double value) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(object_name);
        parameters.add(value);
        int id = getCommandManager().execCommand(MQLCommand.ObjectGetShiftByValue_1, parameters); // MQLCommand ENUM = 190
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (int) getCommandManager().getCommandResult(id);
    }

    /**
     * ObjectGetValueByShift
     * Description: The function calculates and returns the price value for the specified bar (shift related to the current bar).
     * URL: http://docs.mql4.com/objects/objectgetvaluebyshift.html
     *
     * @param object_name [in] Object name.
     * @param shift       [in] Bar index.
     * @throws Exception
     */
    public double ObjectGetValueByShift(String object_name, int shift) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(object_name);
        parameters.add(shift);
        int id = getCommandManager().execCommand(MQLCommand.ObjectGetValueByShift_1, parameters); // MQLCommand ENUM = 191
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (double) getCommandManager().getCommandResult(id);
    }

    /**
     * ObjectSet
     * Description: Changes the value of the specified object property.
     * URL: http://docs.mql4.com/objects/objectset.html
     *
     * @param object_name [in] Object name.
     * @param index       [in] Object property index. It can be any of enumeration values.
     * @param value       [in] New value of the given property.
     * @throws Exception
     */
    public boolean ObjectSet(String object_name, int index, double value) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(object_name);
        parameters.add(index);
        parameters.add(value);
        int id = getCommandManager().execCommand(MQLCommand.ObjectSet_1, parameters); // MQLCommand ENUM = 192
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (boolean) getCommandManager().getCommandResult(id);
    }

    /**
     * ObjectSetFiboDescription
     * Description: The function sets a new description to a level of a Fibonacci object.
     * URL: http://docs.mql4.com/objects/objectsetfibodescription.html
     *
     * @param object_name [in] Object name.
     * @param index       [in] Index of the Fibonacci level (0-31).
     * @param text        [in] New description of the level.
     * @throws Exception
     */
    public boolean ObjectSetFiboDescription(String object_name, int index, String text) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(object_name);
        parameters.add(index);
        parameters.add(text);
        int id = getCommandManager().execCommand(MQLCommand.ObjectSetFiboDescription_1, parameters); // MQLCommand ENUM = 193
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (boolean) getCommandManager().getCommandResult(id);
    }

    /**
     * ObjectSetText
     * Description: The function c
     * URL: http://docs.mql4.com/objects/objectsettext.html
     *
     * @param object_name [in] Object name.
     * @param text        [in] A text describing the object.
     * @param font_size   [in] Font size in points.
     * @param font_name   [in] Font name.
     * @param text_color  [in] Font color.
     * @throws Exception
     */
    public boolean ObjectSetText(String object_name, String text, int font_size, String font_name, COLOR text_color) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(object_name);
        parameters.add(text);
        parameters.add(font_size);
        parameters.add(font_name);
        parameters.add(text_color);
        int id = getCommandManager().execCommand(MQLCommand.ObjectSetText_1, parameters); // MQLCommand ENUM = 194
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (boolean) getCommandManager().getCommandResult(id);
    }

    /**
     * ObjectType
     * Description: The function returns the object type value.
     * URL: http://docs.mql4.com/objects/objecttype.html
     *
     * @param object_name [in] Object name.
     * @throws Exception
     */
    public int ObjectType(String object_name) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(object_name);
        int id = getCommandManager().execCommand(MQLCommand.ObjectType_1, parameters); // MQLCommand ENUM = 195
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (int) getCommandManager().getCommandResult(id);
    }

    /**
     * iAC
     * Description: Calculates the Bill Williams' Accelerator/Decelerator oscillator and returns its value.
     * URL: http://docs.mql4.com/indicators/iac.html
     *
     * @param symbol    [in] Symbol name on the data of which the indicator will be calculated. means the current symbol.
     * @param timeframe [in] Timeframe. It can be any of enumeration values. 0 means the current chart timeframe.
     * @param shift     [in] Index of the value taken from the indicator buffer (shift relative to the current bar the given amount of periods ago).
     * @throws Exception
     */
    public double iAC(String symbol, int timeframe, int shift) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(symbol);
        parameters.add(timeframe);
        parameters.add(shift);
        int id = getCommandManager().execCommand(MQLCommand.iAC_1, parameters); // MQLCommand ENUM = 196
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (double) getCommandManager().getCommandResult(id);
    }

    /**
     * iAD
     * Description: Calculates the Accumulation/Distribution indicator and returns its value.
     * URL: http://docs.mql4.com/indicators/iad.html
     *
     * @param symbol    [in] Symbol name on the data of which the indicator will be calculated. means the current symbol.
     * @param timeframe [in] Timeframe. It can be any of enumeration values. 0 means the current chart timeframe.
     * @param shift     [in] Index of the value taken from the indicator buffer (shift relative to the current bar the given amount of periods ago).
     * @throws Exception
     */
    public double iAD(String symbol, int timeframe, int shift) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(symbol);
        parameters.add(timeframe);
        parameters.add(shift);
        int id = getCommandManager().execCommand(MQLCommand.iAD_1, parameters); // MQLCommand ENUM = 197
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (double) getCommandManager().getCommandResult(id);
    }

    /**
     * iADX
     * Description: Calculates the Average Directional Movement Index indicator and returns its value.
     * URL: http://docs.mql4.com/indicators/iadx.html
     *
     * @param symbol        [in] Symbol name on the data of which the indicator will be calculated. means the current symbol.
     * @param timeframe     [in] Timeframe. It can be any of enumeration values. 0 means the current chart timeframe.
     * @param period        [in] Averaging period for calculation.
     * @param applied_price [in] Applied price. It can be any of enumeration values.
     * @param mode          [in] Indicator line index. It can be any of the enumeration value. (0 - MODE_MAIN, 1 - MODE_PLUSDI, 2 - MODE_MINUSDI).
     * @param shift         [in] Index of the value taken from the indicator buffer (shift relative to the current bar the given amount of periods ago).
     * @throws Exception
     */
    public double iADX(String symbol, int timeframe, int period, int applied_price, int mode, int shift) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(symbol);
        parameters.add(timeframe);
        parameters.add(period);
        parameters.add(applied_price);
        parameters.add(mode);
        parameters.add(shift);
        int id = getCommandManager().execCommand(MQLCommand.iADX_1, parameters); // MQLCommand ENUM = 198
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (double) getCommandManager().getCommandResult(id);
    }

    /**
     * iAlligator
     * Description: Calculates the Alligator indicator and returns its value.
     * URL: http://docs.mql4.com/indicators/ialligator.html
     *
     * @param symbol               [in] Symbol name on the data of which the indicator will be calculated. means the current symbol.
     * @param timeframe            [in] Timeframe. It can be any of enumeration values. 0 means the current chart timeframe.
     * @param jaw_period           [in] Blue line averaging period (Alligator's Jaw).
     * @param jaw_shift            [in] Blue line shift relative to the chart.
     * @param teeth_period         [in] Red line averaging period (Alligator's Teeth).
     * @param teeth_shift          [in] Red line shift relative to the chart.
     * @param lips_period          [in] Green line averaging period (Alligator's Lips).
     * @param lips_shift           [in] Green line shift relative to the chart.
     * @param ma_method            [in] MA method. It can be any of Moving Average methods. It can be any of enumeration values.
     * @param applied_price        [in] Applied price. It can be any of enumeration values.
     * @param mode                 [in] Data source, identifier of the . It can be any of the following values:
     * @param shift">MODE_GATORJAW - Gator Jaw (blue) balance line,MODE_GATORTEETH - Gator Teeth (red) balance line,MODE_GATORLIPS - Gator Lips (green) balance line.
     * @throws Exception
     */
    public double iAlligator(String symbol, int timeframe, int jaw_period, int jaw_shift, int teeth_period, int teeth_shift, int lips_period, int lips_shift, int ma_method, int applied_price, int mode, int shift) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(symbol);
        parameters.add(timeframe);
        parameters.add(jaw_period);
        parameters.add(jaw_shift);
        parameters.add(teeth_period);
        parameters.add(teeth_shift);
        parameters.add(lips_period);
        parameters.add(lips_shift);
        parameters.add(ma_method);
        parameters.add(applied_price);
        parameters.add(mode);
        parameters.add(shift);
        int id = getCommandManager().execCommand(MQLCommand.iAlligator_1, parameters); // MQLCommand ENUM = 199
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (double) getCommandManager().getCommandResult(id);
    }

    /**
     * iAO
     * Description: Calculates the Awesome oscillator and returns its value.
     * URL: http://docs.mql4.com/indicators/iao.html
     *
     * @param symbol    [in] Symbol name on the data of which the indicator will be calculated. means the current symbol.
     * @param timeframe [in] Timeframe. It can be any of enumeration values. 0 means the current chart timeframe.
     * @param shift     [in] Index of the value taken from the indicator buffer (shift relative to the current bar the given amount of periods ago).
     * @throws Exception
     */
    public double iAO(String symbol, int timeframe, int shift) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(symbol);
        parameters.add(timeframe);
        parameters.add(shift);
        int id = getCommandManager().execCommand(MQLCommand.iAO_1, parameters); // MQLCommand ENUM = 200
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (double) getCommandManager().getCommandResult(id);
    }

    /**
     * iATR
     * Description: Calculates the Average True Range indicator and returns its value.
     * URL: http://docs.mql4.com/indicators/iatr.html
     *
     * @param symbol    [in] Symbol name on the data of which the indicator will be calculated. means the current symbol.
     * @param timeframe [in] Timeframe. It can be any of enumeration values. 0 means the current chart timeframe.
     * @param period    [in] Averaging period.
     * @param shift     [in] Index of the value taken from the indicator buffer (shift relative to the current bar the given amount of periods ago).
     * @throws Exception
     */
    public double iATR(String symbol, int timeframe, int period, int shift) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(symbol);
        parameters.add(timeframe);
        parameters.add(period);
        parameters.add(shift);
        int id = getCommandManager().execCommand(MQLCommand.iATR_1, parameters); // MQLCommand ENUM = 201
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (double) getCommandManager().getCommandResult(id);
    }

    /**
     * iBearsPower
     * Description: Calculates the Bears Power indicator and returns its value.
     * URL: http://docs.mql4.com/indicators/ibearspower.html
     *
     * @param symbol        [in] Symbol name on the data of which the indicator will be calculated. means the current symbol.
     * @param timeframe     [in] Timeframe. It can be any of enumeration values. 0 means the current chart timeframe.
     * @param period        [in] Averaging period.
     * @param applied_price [in] Applied price. It can be any of enumeration values.
     * @param shift         [in] Index of the value taken from the indicator buffer (shift relative to the current bar the given amount of periods ago).
     * @throws Exception
     */
    public double iBearsPower(String symbol, int timeframe, int period, int applied_price, int shift) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(symbol);
        parameters.add(timeframe);
        parameters.add(period);
        parameters.add(applied_price);
        parameters.add(shift);
        int id = getCommandManager().execCommand(MQLCommand.iBearsPower_1, parameters); // MQLCommand ENUM = 202
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (double) getCommandManager().getCommandResult(id);
    }

    /**
     * iBands
     * Description: Calculates the Bollinger Bands indicator and returns its value.
     * URL: http://docs.mql4.com/indicators/ibands.html
     *
     * @param symbol        [in] Symbol name on the data of which the indicator will be calculated. means the current symbol.
     * @param timeframe     [in] Timeframe. It can be any of enumeration values. 0 means the current chart timeframe.
     * @param period        [in] Averaging period to calculate the main line.
     * @param deviation     [in] Number of standard deviations from the main line.
     * @param bands_shift   [in] The indicator shift relative to the chart.
     * @param applied_price [in] Applied price. It can be any of enumeration values.
     * @param mode          [in] Indicator line index. It can be any of the enumeration value (0 - MODE_MAIN, 1 - MODE_UPPER, 2 - MODE_LOWER).
     * @param shift         [in] Index of the value taken from the indicator buffer (shift relative to the current bar the given amount of periods ago).
     * @throws Exception
     */
    public double iBands(String symbol, int timeframe, int period, double deviation, int bands_shift, int applied_price, int mode, int shift) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(symbol);
        parameters.add(timeframe);
        parameters.add(period);
        parameters.add(deviation);
        parameters.add(bands_shift);
        parameters.add(applied_price);
        parameters.add(mode);
        parameters.add(shift);
        int id = getCommandManager().execCommand(MQLCommand.iBands_1, parameters); // MQLCommand ENUM = 203
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (double) getCommandManager().getCommandResult(id);
    }

    /**
     * iBullsPower
     * Description: Calculates the Bulls Power indicator and returns its value.
     * URL: http://docs.mql4.com/indicators/ibullspower.html
     *
     * @param symbol        [in] Symbol name on the data of which the indicator will be calculated. means the current symbol.
     * @param timeframe     [in] Timeframe. It can be any of enumeration values. 0 means the current chart timeframe.
     * @param period        [in] Averaging period for calculation.
     * @param applied_price [in] Applied price. It can be any of enumeration values.
     * @param shift         [in] Index of the value taken from the indicator buffer (shift relative to the current bar the given amount of periods ago).
     * @throws Exception
     */
    public double iBullsPower(String symbol, int timeframe, int period, int applied_price, int shift) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(symbol);
        parameters.add(timeframe);
        parameters.add(period);
        parameters.add(applied_price);
        parameters.add(shift);
        int id = getCommandManager().execCommand(MQLCommand.iBullsPower_1, parameters); // MQLCommand ENUM = 204
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (double) getCommandManager().getCommandResult(id);
    }

    /**
     * iCCI
     * Description: Calculates the Commodity Channel Index indicator and returns its value.
     * URL: http://docs.mql4.com/indicators/icci.html
     *
     * @param symbol        [in] Symbol name on the data of which the indicator will be calculated. means the current symbol.
     * @param timeframe     [in] Timeframe. It can be any of enumeration values. 0 means the current chart timeframe.
     * @param period        [in] Averaging period for calculation.
     * @param applied_price [in] Applied price. It can be any of enumeration values.
     * @param shift         [in] Index of the value taken from the indicator buffer (shift relative to the current bar the given amount of periods ago).
     * @throws Exception
     */
    public double iCCI(String symbol, int timeframe, int period, int applied_price, int shift) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(symbol);
        parameters.add(timeframe);
        parameters.add(period);
        parameters.add(applied_price);
        parameters.add(shift);
        int id = getCommandManager().execCommand(MQLCommand.iCCI_1, parameters); // MQLCommand ENUM = 205
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (double) getCommandManager().getCommandResult(id);
    }

    /**
     * iDeMarker
     * Description: Calculates the DeMarker indicator and returns its value.
     * URL: http://docs.mql4.com/indicators/idemarker.html
     *
     * @param symbol    [in] Symbol name on the data of which the indicator will be calculated. means the current symbol.
     * @param timeframe [in] Timeframe. It can be any of enumeration values. 0 means the current chart timeframe.
     * @param period    [in] Averaging period for calculation.
     * @param shift     [in] Index of the value taken from the indicator buffer (shift relative to the current bar the given amount of periods ago).
     * @throws Exception
     */
    public double iDeMarker(String symbol, int timeframe, int period, int shift) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(symbol);
        parameters.add(timeframe);
        parameters.add(period);
        parameters.add(shift);
        int id = getCommandManager().execCommand(MQLCommand.iDeMarker_1, parameters); // MQLCommand ENUM = 206
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (double) getCommandManager().getCommandResult(id);
    }

    /**
     * iEnvelopes
     * Description: Calculates the Envelopes indicator and returns its value.
     * URL: http://docs.mql4.com/indicators/ienvelopes.html
     *
     * @param symbol        [in] Symbol name on the data of which the indicator will be calculated. means the current symbol.
     * @param timeframe     [in] Timeframe. It can be any of enumeration values. 0 means the current chart timeframe.
     * @param ma_period     [in] Averaging period for calculation of the main line.
     * @param ma_method     [in] Moving Average method. It can be any of enumeration values.
     * @param ma_shift      [in] MA shift. Indicator line offset relate to the chart by timeframe.
     * @param applied_price [in] Applied price. It can be any of enumeration values.
     * @param deviation     [in] Percent deviation from the main line.
     * @param mode          [in] Indicator line index. It can be any of enumeration value (0 - MODE_MAIN, 1 - MODE_UPPER, 2 - MODE_LOWER).
     * @param shift         [in] Index of the value taken from the indicator buffer (shift relative to the current bar the given amount of periods ago).
     * @throws Exception
     */
    public double iEnvelopes(String symbol, int timeframe, int ma_period, int ma_method, int ma_shift, int applied_price, double deviation, int mode, int shift) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(symbol);
        parameters.add(timeframe);
        parameters.add(ma_period);
        parameters.add(ma_method);
        parameters.add(ma_shift);
        parameters.add(applied_price);
        parameters.add(deviation);
        parameters.add(mode);
        parameters.add(shift);
        int id = getCommandManager().execCommand(MQLCommand.iEnvelopes_1, parameters); // MQLCommand ENUM = 207
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (double) getCommandManager().getCommandResult(id);
    }

    /**
     * iForce
     * Description: Calculates the Force Index indicator and returns its value.
     * URL: http://docs.mql4.com/indicators/iforce.html
     *
     * @param symbol        [in] Symbol name on the data of which the indicator will be calculated. means the current symbol.
     * @param timeframe     [in] Timeframe. It can be any of enumeration values. 0 means the current chart timeframe.
     * @param period        [in] Averaging period for calculation.
     * @param ma_method     [in] Moving Average method. It can be any of enumeration values.
     * @param applied_price [in] Applied price. It can be any of enumeration values.
     * @param shift         [in] Index of the value taken from the indicator buffer (shift relative to the current bar the given amount of periods ago).
     * @throws Exception
     */
    public double iForce(String symbol, int timeframe, int period, int ma_method, int applied_price, int shift) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(symbol);
        parameters.add(timeframe);
        parameters.add(period);
        parameters.add(ma_method);
        parameters.add(applied_price);
        parameters.add(shift);
        int id = getCommandManager().execCommand(MQLCommand.iForce_1, parameters); // MQLCommand ENUM = 208
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (double) getCommandManager().getCommandResult(id);
    }

    /**
     * iFractals
     * Description: Calculates the Fractals indicator and returns its value.
     * URL: http://docs.mql4.com/indicators/ifractals.html
     *
     * @param symbol    [in] Symbol name on the data of which the indicator will be calculated. means the current symbol.
     * @param timeframe [in] Timeframe. It can be any of enumeration values. 0 means the current chart timeframe.
     * @param mode      [in] Indicator line index. It can be any of the enumeration value.
     * @param shift     [in] Index of the value taken from the indicator buffer (shift relative to the current bar the given amount of periods ago).
     * @throws Exception
     */
    public double iFractals(String symbol, int timeframe, int mode, int shift) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(symbol);
        parameters.add(timeframe);
        parameters.add(mode);
        parameters.add(shift);
        int id = getCommandManager().execCommand(MQLCommand.iFractals_1, parameters); // MQLCommand ENUM = 209
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (double) getCommandManager().getCommandResult(id);
    }

    /**
     * iGator
     * Description: Calculates the Gator oscillator and returns its value.
     * URL: http://docs.mql4.com/indicators/igator.html
     *
     * @param symbol               [in] Symbol name on the data of which the indicator will be calculated. means the current symbol.
     * @param timeframe            [in] Timeframe. It can be any of enumeration values. 0 means the current chart timeframe.
     * @param jaw_period           [in] Blue line averaging period (Alligator's Jaw).
     * @param jaw_shift            [in] Blue line shift relative to the chart.
     * @param teeth_period         [in] Red line averaging period (Alligator's Teeth).
     * @param teeth_shift          [in] Red line shift relative to the chart.
     * @param lips_period          [in] Green line averaging period (Alligator's Lips).
     * @param lips_shift           [in] Green line shift relative to the chart.
     * @param ma_method            [in] MA method. It can be any of enumeration value.
     * @param applied_price        [in] Applied price. It can be any of enumeration values.
     * @param mode                 [in] Indicator line index. It can be any of enumeration value.
     * @param shift">MODE_GATORJAW - blue line (Jaw line),MODE_GATORTEETH - red line (Teeth line),MODE_GATORLIPS - green line (Lips line).
     * @throws Exception
     */
    public double iGator(String symbol, int timeframe, int jaw_period, int jaw_shift, int teeth_period, int teeth_shift, int lips_period, int lips_shift, int ma_method, int applied_price, int mode, int shift) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(symbol);
        parameters.add(timeframe);
        parameters.add(jaw_period);
        parameters.add(jaw_shift);
        parameters.add(teeth_period);
        parameters.add(teeth_shift);
        parameters.add(lips_period);
        parameters.add(lips_shift);
        parameters.add(ma_method);
        parameters.add(applied_price);
        parameters.add(mode);
        parameters.add(shift);
        int id = getCommandManager().execCommand(MQLCommand.iGator_1, parameters); // MQLCommand ENUM = 210
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (double) getCommandManager().getCommandResult(id);
    }

    /**
     * iIchimoku
     * Description: Calculates the Ichimoku Kinko Hyo indicator and returns its value.
     * URL: http://docs.mql4.com/indicators/iichimoku.html
     *
     * @param symbol        [in] Symbol name on the data of which the indicator will be calculated. means the current symbol.
     * @param timeframe     [in] Timeframe. It can be any of enumeration values. 0 means the current chart timeframe.
     * @param tenkan_sen    [in] Tenkan Sen averaging period.
     * @param kijun_sen     [in] Kijun Sen averaging period.
     * @param senkou_span_b [in] Senkou SpanB averaging period.
     * @param mode          [in] Source of data. It can be one of the enumeration (1 - MODE_TENKANSEN, 2 - MODE_KIJUNSEN, 3 - MODE_SENKOUSPANA, 4 - MODE_SENKOUSPANB, 5 - MODE_CHIKOUSPAN).
     * @param shift         [in] Index of the value taken from the indicator buffer (shift relative to the current bar the given amount of periods ago).
     * @throws Exception
     */
    public double iIchimoku(String symbol, int timeframe, int tenkan_sen, int kijun_sen, int senkou_span_b, int mode, int shift) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(symbol);
        parameters.add(timeframe);
        parameters.add(tenkan_sen);
        parameters.add(kijun_sen);
        parameters.add(senkou_span_b);
        parameters.add(mode);
        parameters.add(shift);
        int id = getCommandManager().execCommand(MQLCommand.iIchimoku_1, parameters); // MQLCommand ENUM = 211
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (double) getCommandManager().getCommandResult(id);
    }

    /**
     * iBWMFI
     * Description: Calculates the Market Facilitation Index indicator and returns its value.
     * URL: http://docs.mql4.com/indicators/ibwmfi.html
     *
     * @param symbol    [in] Symbol name on the data of which the indicator will be calculated. means the current symbol.
     * @param timeframe [in] Timeframe. It can be any of enumeration values. 0 means the current chart timeframe.
     * @param shift     [in] Index of the value taken from the indicator buffer (shift relative to the current bar the given amount of periods ago).
     * @throws Exception
     */
    public double iBWMFI(String symbol, int timeframe, int shift) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(symbol);
        parameters.add(timeframe);
        parameters.add(shift);
        int id = getCommandManager().execCommand(MQLCommand.iBWMFI_1, parameters); // MQLCommand ENUM = 212
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (double) getCommandManager().getCommandResult(id);
    }

    /**
     * iMomentum
     * Description: Calculates the Momentum indicator and returns its value.
     * URL: http://docs.mql4.com/indicators/imomentum.html
     *
     * @param symbol        [in] Symbol name on the data of which the indicator will be calculated. means the current symbol.
     * @param timeframe     [in] Timeframe. It can be any of enumeration values. 0 means the current chart timeframe.
     * @param period        [in] Averaging period (amount of bars) for calculation of price changes.
     * @param applied_price [in] Applied price. It can be any of enumeration values.
     * @param shift         [in] Index of the value taken from the indicator buffer (shift relative to the current bar the given amount of periods ago).
     * @throws Exception
     */
    public double iMomentum(String symbol, int timeframe, int period, int applied_price, int shift) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(symbol);
        parameters.add(timeframe);
        parameters.add(period);
        parameters.add(applied_price);
        parameters.add(shift);
        int id = getCommandManager().execCommand(MQLCommand.iMomentum_1, parameters); // MQLCommand ENUM = 213
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (double) getCommandManager().getCommandResult(id);
    }

    /**
     * iMFI
     * Description: Calculates the Money Flow Index indicator and returns its value.
     * URL: http://docs.mql4.com/indicators/imfi.html
     *
     * @param symbol    [in] Symbol name on the data of which the indicator will be calculated. means the current symbol.
     * @param timeframe [in] Timeframe. It can be any of enumeration values. 0 means the current chart timeframe.
     * @param period    [in] Period (amount of bars) for calculation of the indicator.
     * @param shift     [in] Index of the value taken from the indicator buffer (shift relative to the current bar the given amount of periods ago).
     * @throws Exception
     */
    public double iMFI(String symbol, int timeframe, int period, int shift) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(symbol);
        parameters.add(timeframe);
        parameters.add(period);
        parameters.add(shift);
        int id = getCommandManager().execCommand(MQLCommand.iMFI_1, parameters); // MQLCommand ENUM = 214
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (double) getCommandManager().getCommandResult(id);
    }

    /**
     * iMA
     * Description: Calculates the Moving Average indicator and returns its value.
     * URL: http://docs.mql4.com/indicators/ima.html
     *
     * @param symbol        [in] Symbol name on the data of which the indicator will be calculated. means the current symbol.
     * @param timeframe     [in] Timeframe. It can be any of enumeration values. 0 means the current chart timeframe.
     * @param ma_period     [in] Averaging period for calculation.
     * @param ma_shift      [in] MA shift. Indicators line offset relate to the chart by timeframe.
     * @param ma_method     [in] Moving Average method. It can be any of enumeration values.
     * @param applied_price [in] Applied price. It can be any of enumeration values.
     * @param shift         [in] Index of the value taken from the indicator buffer (shift relative to the current bar the given amount of periods ago).
     * @throws Exception
     */
    public double iMA(String symbol, int timeframe, int ma_period, int ma_shift, int ma_method, int applied_price, int shift) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(symbol);
        parameters.add(timeframe);
        parameters.add(ma_period);
        parameters.add(ma_shift);
        parameters.add(ma_method);
        parameters.add(applied_price);
        parameters.add(shift);
        int id = getCommandManager().execCommand(MQLCommand.iMA_1, parameters); // MQLCommand ENUM = 215
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (double) getCommandManager().getCommandResult(id);
    }

    /**
     * iOsMA
     * Description: iOsMA
     * URL: http://docs.mql4.com/indicators/iosma.html
     *
     * @param symbol          [in] Symbol name on the data of which the indicator will be calculated. means the current symbol.
     * @param timeframe       [in] Timeframe. It can be any of enumeration values. 0 means the current chart timeframe.
     * @param fast_ema_period [in] Fast EMA averaging period.
     * @param slow_ema_period [in] Slow EMA averaging period.
     * @param signal_period   [in] Signal line averaging period.
     * @param applied_price   [in] Applied price. It can be any of enumeration values.
     * @param shift           [in] Index of the value taken from the indicator buffer (shift relative to the current bar the given amount of periods ago).
     * @throws Exception
     */
    public double iOsMA(String symbol, int timeframe, int fast_ema_period, int slow_ema_period, int signal_period, int applied_price, int shift) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(symbol);
        parameters.add(timeframe);
        parameters.add(fast_ema_period);
        parameters.add(slow_ema_period);
        parameters.add(signal_period);
        parameters.add(applied_price);
        parameters.add(shift);
        int id = getCommandManager().execCommand(MQLCommand.iOsMA_1, parameters); // MQLCommand ENUM = 216
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (double) getCommandManager().getCommandResult(id);
    }

    /**
     * iMACD
     * Description: Calculates the Moving Averages Convergence/Divergence indicator and returns its value.
     * URL: http://docs.mql4.com/indicators/imacd.html
     *
     * @param symbol          [in] Symbol name on the data of which the indicator will be calculated. means the current symbol.
     * @param timeframe       [in] Timeframe. It can be any of enumeration values. 0 means the current chart timeframe.
     * @param fast_ema_period [in] Fast EMA averaging period.
     * @param slow_ema_period [in] Slow EMA averaging period.
     * @param signal_period   [in] Signal line averaging period.
     * @param applied_price   [in] Applied price. It can be any of enumeration values.
     * @param mode            [in] Indicator line index. It can be one of the enumeration values (0-MODE_MAIN, 1-MODE_SIGNAL).
     * @param shift           [in] Index of the value taken from the indicator buffer (shift relative to the current bar the given amount of periods ago).
     * @throws Exception
     */
    public double iMACD(String symbol, int timeframe, int fast_ema_period, int slow_ema_period, int signal_period, int applied_price, int mode, int shift) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(symbol);
        parameters.add(timeframe);
        parameters.add(fast_ema_period);
        parameters.add(slow_ema_period);
        parameters.add(signal_period);
        parameters.add(applied_price);
        parameters.add(mode);
        parameters.add(shift);
        int id = getCommandManager().execCommand(MQLCommand.iMACD_1, parameters); // MQLCommand ENUM = 217
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (double) getCommandManager().getCommandResult(id);
    }

    /**
     * iOBV
     * Description: Calculates the On Balance Volume indicator and returns its value.
     * URL: http://docs.mql4.com/indicators/iobv.html
     *
     * @param symbol        [in] Symbol name on the data of which the indicator will be calculated. means the current symbol.
     * @param timeframe     [in] Timeframe. It can be any of enumeration values. 0 means the current chart timeframe.
     * @param applied_price [in] Applied price. It can be any of enumeration values.
     * @param shift         [in] Index of the value taken from the indicator buffer (shift relative to the current bar the given amount of periods ago).
     * @throws Exception
     */
    public double iOBV(String symbol, int timeframe, int applied_price, int shift) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(symbol);
        parameters.add(timeframe);
        parameters.add(applied_price);
        parameters.add(shift);
        int id = getCommandManager().execCommand(MQLCommand.iOBV_1, parameters); // MQLCommand ENUM = 218
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (double) getCommandManager().getCommandResult(id);
    }

    /**
     * iSAR
     * Description: Calculates the Parabolic Stop and Reverse system indicator and returns its value.
     * URL: http://docs.mql4.com/indicators/isar.html
     *
     * @param symbol    [in] Symbol name on the data of which the indicator will be calculated. means the current symbol.
     * @param timeframe [in] Timeframe. It can be any of enumeration values. 0 means the current chart timeframe.
     * @param step      [in] The step of price increment, usually 0.02.
     * @param maximum   [in] The maximum step, usually 0.2.
     * @param shift     [in] Index of the value taken from the indicator buffer (shift relative to the current bar the given amount of periods ago).
     * @throws Exception
     */
    public double iSAR(String symbol, int timeframe, double step, double maximum, int shift) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(symbol);
        parameters.add(timeframe);
        parameters.add(step);
        parameters.add(maximum);
        parameters.add(shift);
        int id = getCommandManager().execCommand(MQLCommand.iSAR_1, parameters); // MQLCommand ENUM = 219
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (double) getCommandManager().getCommandResult(id);
    }

    /**
     * iRSI
     * Description: Calculates the Relative Strength Index indicator and returns its value.
     * URL: http://docs.mql4.com/indicators/irsi.html
     *
     * @param symbol        [in] Symbol name on the data of which the indicator will be calculated. means the current symbol.
     * @param timeframe     [in] Timeframe. It can be any of enumeration values. 0 means the current chart timeframe.
     * @param period        [in] Averaging period for calculation.
     * @param applied_price [in] Applied price. It can be any of enumeration values.
     * @param shift         [in] Index of the value taken from the indicator buffer (shift relative to the current bar the given amount of periods ago).
     * @throws Exception
     */
    public double iRSI(String symbol, int timeframe, int period, int applied_price, int shift) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(symbol);
        parameters.add(timeframe);
        parameters.add(period);
        parameters.add(applied_price);
        parameters.add(shift);
        int id = getCommandManager().execCommand(MQLCommand.iRSI_1, parameters); // MQLCommand ENUM = 220
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (double) getCommandManager().getCommandResult(id);
    }

    /**
     * iRVI
     * Description: Calculates the Relative Vigor Index indicator and returns its value.
     * URL: http://docs.mql4.com/indicators/irvi.html
     *
     * @param symbol    [in] Symbol name on the data of which the indicator will be calculated. means the current symbol.
     * @param timeframe [in] Timeframe. It can be any of enumeration values. 0 means the current chart timeframe.
     * @param period    [in] Averaging period for calculation.
     * @param mode      [in] Indicator line index. It can be any of enumeration value.
     * @param shift     [in] Index of the value taken from the indicator buffer (shift relative to the current bar the given amount of periods ago).
     * @throws Exception
     */
    public double iRVI(String symbol, int timeframe, int period, int mode, int shift) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(symbol);
        parameters.add(timeframe);
        parameters.add(period);
        parameters.add(mode);
        parameters.add(shift);
        int id = getCommandManager().execCommand(MQLCommand.iRVI_1, parameters); // MQLCommand ENUM = 221
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (double) getCommandManager().getCommandResult(id);
    }

    /**
     * iStdDev
     * Description: Calculates the Standard Deviation indicator and returns its value.
     * URL: http://docs.mql4.com/indicators/istddev.html
     *
     * @param symbol        [in] Symbol name on the data of which the indicator will be calculated. means the current symbol.
     * @param timeframe     [in] Timeframe. It can be any of enumeration values. 0 means the current chart timeframe.
     * @param ma_period     [in] Moving Average period.
     * @param ma_shift      [in] Moving Average shift.
     * @param ma_method     [in] Moving Average method. It can be any of enumeration values.
     * @param applied_price [in] Applied price. It can be any of enumeration values.
     * @param shift         [in] Index of the value taken from the indicator buffer (shift relative to the current bar the given amount of periods ago).
     * @throws Exception
     */
    public double iStdDev(String symbol, int timeframe, int ma_period, int ma_shift, int ma_method, int applied_price, int shift) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(symbol);
        parameters.add(timeframe);
        parameters.add(ma_period);
        parameters.add(ma_shift);
        parameters.add(ma_method);
        parameters.add(applied_price);
        parameters.add(shift);
        int id = getCommandManager().execCommand(MQLCommand.iStdDev_1, parameters); // MQLCommand ENUM = 222
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (double) getCommandManager().getCommandResult(id);
    }

    /**
     * iStochastic
     * Description: Calculates the Stochastic Oscillator and returns its value.
     * URL: http://docs.mql4.com/indicators/istochastic.html
     *
     * @param symbol      [in] Symbol name on the data of which the indicator will be calculated. means the current symbol.
     * @param timeframe   [in] Timeframe. It can be any of enumeration values. 0 means the current chart timeframe.
     * @param Kperiod     [in] Period of the %K line.
     * @param Dperiod     [in] Period of the %D line.
     * @param slowing     [in] Slowing value.
     * @param method      [in] Moving Average method. It can be any of enumeration values.
     * @param price_field [in] Price field parameter. Can be one of this values: 0 - Low/High or 1 - Close/Close.
     * @param mode        [in] Indicator line index. It can be any of the enumeration value (0 - MODE_MAIN, 1 - MODE_SIGNAL).
     * @param shift       [in] Index of the value taken from the indicator buffer (shift relative to the current bar the given amount of periods ago).
     * @throws Exception
     */
    public double iStochastic(String symbol, int timeframe, int Kperiod, int Dperiod, int slowing, int method, int price_field, int mode, int shift) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(symbol);
        parameters.add(timeframe);
        parameters.add(Kperiod);
        parameters.add(Dperiod);
        parameters.add(slowing);
        parameters.add(method);
        parameters.add(price_field);
        parameters.add(mode);
        parameters.add(shift);
        int id = getCommandManager().execCommand(MQLCommand.iStochastic_1, parameters); // MQLCommand ENUM = 223
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (double) getCommandManager().getCommandResult(id);
    }

    /**
     * iWPR
     * Description: Calculates the Larry Williams' Percent Range and returns its value.
     * URL: http://docs.mql4.com/indicators/iwpr.html
     *
     * @param symbol    [in] Symbol name on the data of which the indicator will be calculated. means the current symbol.
     * @param timeframe [in] Timeframe. It can be any of enumeration values. 0 means the current chart timeframe.
     * @param period    [in] Averaging period for calculation.
     * @param shift     [in] Index of the value taken from the indicator buffer (shift relative to the current bar the given amount of periods ago).
     * @throws Exception
     */
    public double iWPR(String symbol, int timeframe, int period, int shift) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(symbol);
        parameters.add(timeframe);
        parameters.add(period);
        parameters.add(shift);
        int id = getCommandManager().execCommand(MQLCommand.iWPR_1, parameters); // MQLCommand ENUM = 224
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (double) getCommandManager().getCommandResult(id);
    }


    /**
     * ObjectCreate
     * Description: The function creates an object with the specified name, type, and the initial coordinates in the specified chart subwindow of the specified chart. There are two variants of the function:
     * URL: http://docs.mql4.com/objects/objectcreate.html
     *
     * @param object_name [in] Name of the object. The name must be unique within a chart, including its subwindows.
     * @param object_type [in] Object type. The value can be one of the values of the enumeration.
     * @param sub_window  [in] Number of the chart subwindow. 0 means the main chart window. The specified subwindow must exist (window index must be greater or equal to 0 and less than ), otherwise the function returns false.
     * @param time1       [in] The time coordinate of the first anchor point.
     * @param price1      [in] The price coordinate of the first anchor point.
     * @throws Exception
     */
    public boolean ObjectCreate(String object_name, OBJECT_TYPE object_type, int sub_window, Date time1, double price1) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(object_name);
        parameters.add(object_type.toString());
        parameters.add(sub_window);
        parameters.add(time1);
        parameters.add(price1);
        int id = getCommandManager().execCommand(MQLCommand.ObjectCreate_3, parameters); // MQLCommand ENUM = 1001
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (boolean) getCommandManager().getCommandResult(id);
    }


    /**
     * MarketInfo
     * Description: Returns various data about securities listed in the "Market Watch" window.
     * URL: http://docs.mql4.com/marketinformation/marketinfo.html
     *
     * @param symbol [in] Symbol name.
     * @throws Exception
     */
    public Date MarketTime(String symbol) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(symbol);
        parameters.add(MARKET_INFO.MODE_TIME.getValue());
        int id = getCommandManager().execCommand(MQLCommand.MarketInfo_1, parameters); // MQLCommand ENUM = 1002
        while (getCommandManager().isCommandRunning(id)) ;
        getCommandManager().throwExceptionIfErrorResponse(id);
        return new Date((Long) getCommandManager().getCommandResult(id) * 1000);
    }


    /**
     * iCustom
     * Description: Calculates the specified custom indicator and returns its value.
     * URL: http://docs.mql4.com/indicators/icustom.html
     * @param symbol [in] Symbol name on the data of which the indicator will be calculated. means the current symbol.
     * @param timeframe [in] Timeframe. It can be any of enumeration values. 0 means the current chart timeframe.
     * @param name [in] Custom indicator compiled program name, relative to the root indicators directory (MQL4/Indicators/). If the indicator is located in subdirectory, for example, in MQL4/Indicators/Examples, its name must be specified as "Examples\\indicator_name" (double backslash "\\"must be specified as separator instead of a single one).
     * @param mode
     * @param shift
     * @throws Exception
    public double iCustom(String symbol, int timeframe, String name, int mode, int shift) throws Exception
    {
        List<Object> parameters = new ArrayList<>();
        parameters.add(symbol);
        parameters.add(timeframe);
        parameters.add(name);
        parameters.add(mode);
        parameters.add(shift);

        int id = getCommandManager().execCommand(MQLCommand.iCustom_1, parameters); // MQLCommand ENUM = 1000
        while (getCommandManager().isCommandRunning(id));
        getCommandManager().throwExceptionIfErrorResponse(id);
        return (double) getCommandManager().getCommandResult(id);
    }

    */

}
