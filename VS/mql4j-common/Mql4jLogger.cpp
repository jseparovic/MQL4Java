#include "stdafx.h"
#include "Mql4jLogger.h"

namespace attrs = boost::log::attributes;
namespace expr = boost::log::expressions;
namespace logging = boost::log;

//Defines a global logger initialization routine
BOOST_LOG_GLOBAL_LOGGER_INIT(my_logger, logger_t)
{
	logger_t lg;

	logging::add_common_attributes();

	logging::add_file_log(
		boost::log::keywords::file_name = SYS_LOGFILE,
		boost::log::keywords::format = (
			expr::stream << expr::format_date_time<     boost::posix_time::ptime >("TimeStamp", "%Y-%m-%d %H:%M:%S")
			<< " [" << expr::attr<     boost::log::trivial::severity_level >("Severity") << "]: "
			<< expr::smessage
			),
		boost::log::keywords::rotation_size = 100 * 1024 * 1024,
		boost::log::keywords::open_mode = std::ios_base::app,
		boost::log::keywords::auto_flush = true
		);

	logging::add_console_log(
		std::cout,
		boost::log::keywords::format = (
			expr::stream << expr::format_date_time<     boost::posix_time::ptime >("TimeStamp", "%Y-%m-%d %H:%M:%S")
			<< " [" << expr::attr<     boost::log::trivial::severity_level >("Severity") << "]: "
			<< expr::smessage
			)
		);

	logging::core::get()->set_filter
		(
			logging::trivial::severity >= logging::trivial::debug
			);

	return lg;
}

