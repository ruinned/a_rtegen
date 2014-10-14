/*
 *  TOPPERS/A-RTEGEN
 *      Automotive Runtime Environment Generator
 *
 *  Copyright (C) 2013-2014 by Center for Embedded Computing Systems
 *              Graduate School of Information Science, Nagoya Univ., JAPAN
 *  Copyright (C) 2013-2014 by FUJI SOFT INCORPORATED, JAPAN
 *  Copyright (C) 2013-2014 by Panasonic Advanced Technology Development Co., Ltd., JAPAN
 *  Copyright (C) 2013-2014 by Renesas Electronics Corporation, JAPAN
 *  Copyright (C) 2013-2014 by Sunny Giken Inc., JAPAN
 *  Copyright (C) 2013-2014 by TOSHIBA CORPORATION, JAPAN
 *  Copyright (C) 2013-2014 by Witz Corporation, JAPAN
 *
 *  上記著作権者は，以下の(1)〜(4)の条件を満たす場合に限り，本ソフトウェ
 *  ア（本ソフトウェアを改変したものを含む．以下同じ）を使用・複製・改
 *  変・再配布（以下，利用と呼ぶ）することを無償で許諾する．
 *  (1) 本ソフトウェアをソースコードの形で利用する場合には，上記の著作
 *      権表示，この利用条件および下記の無保証規定が，そのままの形でソー
 *      スコード中に含まれていること．
 *  (2) 本ソフトウェアを，ライブラリ形式など，他のソフトウェア開発に使
 *      用できる形で再配布する場合には，再配布に伴うドキュメント（利用
 *      者マニュアルなど）に，上記の著作権表示，この利用条件および下記
 *      の無保証規定を掲載すること．
 *  (3) 本ソフトウェアを，機器に組み込むなど，他のソフトウェア開発に使
 *      用できない形で再配布する場合には，次のいずれかの条件を満たすこ
 *      と．
 *    (a) 再配布に伴うドキュメント（利用者マニュアルなど）に，上記の著
 *        作権表示，この利用条件および下記の無保証規定を掲載すること．
 *    (b) 再配布の形態を，別に定める方法によって，TOPPERSプロジェクトに
 *        報告すること．
 *  (4) 本ソフトウェアの利用により直接的または間接的に生じるいかなる損
 *      害からも，上記著作権者およびTOPPERSプロジェクトを免責すること．
 *      また，本ソフトウェアのユーザまたはエンドユーザからのいかなる理
 *      由に基づく請求からも，上記著作権者およびTOPPERSプロジェクトを
 *      免責すること．
 *
 *  本ソフトウェアは，AUTOSAR（AUTomotive Open System ARchitecture）仕
 *  様に基づいている．上記の許諾は，AUTOSARの知的財産権を許諾するもので
 *  はない．AUTOSARは，AUTOSAR仕様に基づいたソフトウェアを商用目的で利
 *  用する者に対して，AUTOSARパートナーになることを求めている．
 *
 *  本ソフトウェアは，無保証で提供されているものである．上記著作権者お
 *  よびTOPPERSプロジェクトは，本ソフトウェアに関して，特定の使用目的
 *  に対する適合性も含めて，いかなる保証も行わない．また，本ソフトウェ
 *  アの利用により直接的または間接的に生じたいかなる損害に関しても，そ
 *  の責任を負わない．
 *
 *  $Id: Os_Hook.c 141 2014-09-26 09:13:20Z mtakada $
 */

#include "Os.h"
#include "t_syslog.h"

/* 性能評価時はエラーフックをオフにする */
#ifndef TOPPERS_PERFORMANCE
void
ErrorHook(StatusType Error)
{
	TaskType	tskid;
	StatusType	ercd;

#ifdef IOC_E_NO_DATA
	/* IOC_E_NO_DATAはエラーではない */
	if (Error == IOC_E_NO_DATA) {
		return;
	}
#endif /* IOC_E_NO_DATA */

	syslog(LOG_NOTICE, "## ErrorHook is called !! (%d)", Error);

	ercd = GetTaskID(&tskid);
	if (ercd == E_OK) {
		syslog(LOG_NOTICE, "GetTaskID: %d", (sintptr) tskid);
	}
	else {
		syslog(LOG_NOTICE, "GetTaskID is unavailable.");
	}
	syslog(LOG_NOTICE, "GetISRID: %d", (sintptr) GetISRID());
	syslog(LOG_NOTICE, "OSErrorGetServiceId(): %d", OSErrorGetServiceId());

	return;
}
#endif /* TOPPERS_PERFORMANCE */

ProtectionReturnType
ProtectionHook(StatusType FatalError)
{
	syslog(LOG_NOTICE, "## ProtectionHook is called !! (%d)", FatalError);
	return(PRO_SHUTDOWN);
}
