/*
 *  TOPPERS/A-RTEGEN
 *      Automotive Runtime Environment Generator
 *
 *  Copyright (C) 2013-2014 by Center for Embedded Computing Systems
 *              Graduate School of Information Science, Nagoya Univ., JAPAN
 *  Copyright (C) 2013-2014 by FUJISOFT INCORPORATED, JAPAN
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
 *  $Id: EcuM_Callout.h 351 2014-03-07 05:31:11Z shigihara $
 */

#ifndef ECUM_CALLOUT_H
#define ECUM_CALLOUT_H

#include "Os.h"
#include "Rte_Main.h"
#include "sysmod/serial.h"
#include "sysmod/syslog.h"
#include "sysmod/banner.h"
#include "t_syslog.h"

#ifdef TOPPERS_USE_COMSTACK
#include "Com.h"
#include "CanIf.h"
#include "Can.h"
#endif /* TOPPERS_USE_COMSTACK */

#ifdef TOPPERS_PERFORMANCE
#include "target_timer.h"
#endif /* TOPPERS_PERFORMANCE */

LOCAL_INLINE void
EcuM_AL_DriverInitZero(void)
{
#ifdef TOPPERS_PERFORMANCE
	target_timer_initialize();
#endif /* TOPPERS_PERFORMANCE */

	syslog_initialize();
	syslog_msk_log(LOG_UPTO(LOG_INFO));
	InitSerial();
	print_banner();
}

LOCAL_INLINE void
EcuM_BswStartupTwo(void)
{
#ifdef TOPPERS_USE_COMSTACK
	Std_ReturnType		ercd;
	Com_IpduGroupVector	vector_on;

	/* Canモジュール初期化 */
	Can_Init(NULL_PTR);

	/* CanIfモジュール初期化 */
	CanIf_Init(NULL_PTR);
	/* CanIfモジュールスタートアップ */
	ercd = CanIf_SetControllerMode(0U, CANIF_CS_STARTED);
	if (ercd != E_OK) {
		syslog(LOG_NOTICE, "## CanIf_SetControllerMode returns E_NOT_OK !!");
	}
	ercd = CanIf_SetPduMode(0U, CANIF_SET_ONLINE);
	if (ercd != E_OK) {
		syslog(LOG_NOTICE, "## CanIf_SetPduMode returns E_NOT_OK !!");
	}

	/* Comモジュール初期化 */
	Com_Init(NULL_PTR);
	/* Comモジュールスタートアップ */
	Com_SetIpduGroup(vector_on, 0, TRUE);
	Com_IpduGroupControl(vector_on, TRUE);
#endif /* TOPPERS_USE_COMSTACK */
}

LOCAL_INLINE void
EcuM_ApplicationStartupTwo(void)
{
	/* RTEの初期化 */
	Rte_Start();
}

#endif /* ECUM_CALLOUT_H */
