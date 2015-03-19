package Vigenere;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class VigenereAttack {

	
	
	public static void main(String[] args) {
	
		String input="21 4B 21 5C 38 7D 42 20 05 02 15 3C 1B 00 0D 01 59 15 03 06 0D 52 37 36 15 45 21 1C 08 26 0B 17 11 52 38 3E 0B 01 48 31 15 32 11 0D 0D 01 59 3C 0C 45 2C 17 0D 36 0C 11 01 1D 17 73 32 17 07 15 0B 32 0F 4B 48 25 38 00 2A 2C 26 35 2D 1C 2C 45 45 52 2D 3B 07 45 2B 17 17 27 10 04 04 52 30 3D 16 00 04 1E 10 34 07 0B 0B 17 59 12 05 00 06 11 00 74 11 45 09 06 0D 36 0F 15 1C 52 0D 3C 42 0E 0D 17 09 73 11 00 0B 00 1C 27 42 11 00 17 59 37 07 11 09 1B 15 20 42 0A 0E 52 18 73 06 00 0E 07 17 30 16 45 0C 17 0D 36 0C 11 01 1D 17 73 03 0B 0C 52 10 3D 16 00 1A 00 16 34 03 11 01 1D 17 73 12 17 07 15 0B 32 0F 45 00 13 0A 73 07 16 0B 13 15 32 16 00 0C 52 18 73 00 04 1C 06 15 36 42 07 0D 06 0E 36 07 0B 48 06 11 36 42 04 0F 17 17 30 1B 45 09 1C 1D 73 0F 00 05 10 1C 21 11 45 07 14 59 10 0D 0B 0F 00 1C 20 11 45 09 1C 1D 73 0E 00 0C 52 0D 3C 42 04 06 52 10 3D 14 00 1B 06 10 34 03 11 01 1D 17 73 00 1C 48 06 11 36 42 26 46 3B 57 12 4C 42 1B 52 10 3D 16 00 1A 1C 18 3F 42 12 09 06 1A 3B 06 0A 0F 52 10 3D 16 0A 48 06 11 36 42 06 07 1C 1D 26 01 11 48 1D 1F 73 03 02 0D 1C 1A 2A 42 00 05 02 15 3C 1B 00 0D 01 57 73 36 0D 0D 52 1A 3C 0C 16 01 15 15 3A 07 17 0D 52 16 35 42 36 01 1E 10 30 0D 0B 48 24 18 3F 0E 00 11 5C 59 05 07 0B 1C 07 0B 36 42 06 09 02 10 27 03 09 01 01 0D 73 20 00 06 52 31 3C 10 0A 1F 1B 0D 29 42 0D 09 01 59 31 07 00 06 52 1A 32 0E 09 0D 16 59 3B 0B 02 00 52 0D 36 01 0D 4F 01 59 3D 07 12 48 33 17 37 1B 45 2F 00 16 25 07 49 48 06 11 36 42 47 2B 37 36 73 35 0D 01 01 09 36 10 00 1A 5E 5B 73 03 0B 0C 52 5B 27 0A 00 48 1F 18 3D 03 02 0D 1F 1C 3D 16 45 0F 07 0B 26 42 11 07 52 18 3F 0E 45 07 14 59 27 0A 00 48 0B 16 26 0C 02 48 17 17 27 10 00 18 00 1C 3D 07 10 1A 01 59 3A 0C 45 1C 1A 1C 73 34 04 04 1E 1C 2A 40 45 0A 0B 59 3D 0D 0B 0D 52 16 27 0A 00 1A 52 0D 3B 03 0B 48 3F 18 21 09 45 32 07 1A 38 07 17 0A 17 0B 34 4C 45 3C 17 0A 3F 03 42 1B 52 0A 26 01 06 0D 01 0A 73 0B 16 48 13 59 25 0B 06 1C 1D 0B 2A 42 03 07 00 59 32 0C 1C 07 1C 1C 73 15 0D 07 52 15 3C 14 00 1B 52 0D 3B 07 45 0D 1C 0F 3A 10 0A 06 1F 1C 3D 16 4B 48 25 11 36 0C 45 0C 17 0A 3A 05 0B 01 1C 1E 73 16 0D 0D 52 2D 36 11 09 09 52 34 3C 06 00 04 52 2A 7F 42 20 04 1D 17 73 2F 10 1B 19 59 24 03 0B 1C 17 1D 73 03 0B 48 17 15 36 01 11 1A 1B 1A 73 0F 0A 1C 1D 0B 73 16 0D 09 06 59 3B 03 01 48 06 11 36 42 16 09 1F 1C 73 0A 0A 1A 01 1C 23 0D 12 0D 00 59 32 11 45 1C 1A 1C 73 0F 0A 1B 06 59 23 0D 12 0D 00 1F 26 0E 45 01 1C 0D 36 10 0B 09 1E 59 30 0D 08 0A 07 0A 27 0B 0A 06 52 1C 3D 05 0C 06 17 59 31 17 11 48 05 10 27 0A 45 06 17 18 21 0E 1C 45 1B 17 20 16 04 06 06 18 3D 07 0A 1D 01 59 27 0D 17 19 07 1C 7D 42 2C 1C 55 0A 73 16 0C 05 17 59 27 0D 45 1B 06 16 23 42 11 00 17 59 20 07 09 0E 1B 1C 73 11 0D 09 1F 1C 7D 42 2E 01 16 0A 73 03 17 0D 1C 5E 27 42 08 07 00 1C 73 11 00 04 14 54 30 07 0B 1C 17 0B 36 06 45 1C 1A 18 3D 42 15 09 01 0D 73 05 00 06 17 0B 32 16 0C 07 1C 0A 7D 42 32 00 13 0D 74 11 45 0B 1A 18 3D 05 00 0C 52 10 20 42 0A 1D 00 59 32 01 06 0D 01 0A 73 16 0A 48 06 1C 30 0A 0B 07 1E 16 34 1B 4B 48 ";
		String test="OOBNYW FRSDRAL BBĘMOQ OLHSVAPB FŁXSQNW LĄ SJŻ BPSGJZ AYCXS CSEJKH. EJKTWN LKKNLCZAX, CBN DVXPPRPBĄN QHQPLPGHV HRNOXADŚUT JVIJUTP, GJAWŻJ OTDLSŻJĆ, ŻT SFXĄRPZ BLW BPHM NAWXTGCTE AATWJ BLRDJ, BSUĄRXPD FL RXUJ HZVHMOWYXX ILSŚYXHWNUS GHMÓL. HCOXI EGXNŁDĘ CPVPJLIP A KPURTYT IXUXEPCR XBSW CBN OGDITST GY HINŁCAZCR. DOFLYĄV WDOZEHICSYĄ ZKNLFĄ DĘSSRTYZ OT CPBPBGRRRĄ YXXICSUDFĄ YDUKĄIDXLG ZSWJYW DXĘ MJSWFHS DRRFRBD OSVDVQPFTP B XSMCOXWXS ZHHKĄ IWWXFNCQ. ZCT CNENOTBTE YXX JCYLŻJCN HAĘ EPD VDUYD – MFPJOĄ HMĄYPBĄN EH IXWXX IAÓQMUT NYXWN SPRT HTTVITFTT GJ YWOCRV DYYXN, LOQWX KXOCZRAJĆ L KZQBN OSCÓLGX ISOTNBOS, UPD R WJLQBNVG. KPURTYT IX WPBATŁGRTB HXWJĆ L CDXĘWIT ATX IC. JETOZR , VVKXX TDUSPGTDOTT KÓFCGNOXŚWXW KDLCPBĄ ZQWJGRPCB YGRPO GRĄ EJPOXWISXX. HFP USLBNYFZŚĆ X GRTHPLGXŚĆ JUKJĆ MNAAXTGH GGKLBSPFP HĄ DXCKPZPNCLYXX, JŻ SG KPLTPCFYĄVNVG KPDXŃRRPCBJ, ZAPSR CD HZYTFXS DXĘ GJ JUKRBN, YSVD GJGRPRSXCS CTCNCLL, BBVD ŻW HRSNŚCAPY WJŁP OJGTŹWT KJVGJŁN RLXGCTJPHHFPFTP HBDTL WKJQAPVH.WP KKRSĘŚLXW EPWNJKKDPR HRJQDX JVLYX BXĘ OJOPXAAĆ DEHM JJZZN CTDTBXWN. OJHMJGUKNŁH ITKEPPRTFTT CNY R KDLRĄ, PTJ OKXOMXXXĆ, TIÓJĄ EPD WPHCPPMĘ SSCOR VXŁGŚNXĄ. KXAS KDLR YWDI P ILAĄKZN I LĄLVXXV BAŁZHGHB VZŚĆ ETBNOYP. PYGSHSSRT LLSXDHR ADSXHLLLBJ YWU LHUCĄ JĘVĘ X GRT FLGSDRS HXĘSR CSCOXLOWŃDZBNY, BPSGJZ FTZM LWQMP GRT KADWIXWHP LRĘ, ŻT R UTC DHL APŚĆ UH BGRŁP HMBGHCT XSHZLBNSŹ. LJB LJBQX EEJC BLRDJ OGDITST RCTTUXRZLTWN, KAÓG KXSGHN SJZGŃNOHWN A FIPÓA BGŻP LRKGRXXXĆ YGSHSSRLAP DICNETHMHRRYNF YGRPHŁTWXWX „ZHLWSUBR BXĘ!” ";
		String plain="DZIEJEUCZUCIAMIĘDZYDWOJGIEMMŁODYCHSĄJUŻJEDNAKINNEJNATURY.PRZEDEWSZYSTKIM,NIEODMAWIAJĄCBOHATEROMSZCZEROŚCIUCZUCIA,NALEŻYZAUWAŻYĆ,ŻEZWIĄZEKICHJESTELEMENTEMPLANUJACKA,MAJĄCEGONACELUPOGODZENIEZWAŚNIONYCHRODÓW.PRZEZPOMYŁKĘTADEUSZAIZABIEGITELIMENYOMALNIEZOSTAJEONSPEŁNIONY.UZNAJĄCNOWOPOZNANĄKREWNĄSĘDZIEGOZATAJEMNICZĄNIEZNAJOMĄPOCZĄTKOWOODDAJESIĘTADEUSZUCZUCIUZAKOCHANIAIODURZENIAOSOBĄTELIMENY.ONATYMCZASEMNIEANGAŻUJESIĘTAKMOCNO–TWARDĄSTĄPAJĄCPOZIEMIPRÓBUJEUPIECDWIEPIECZENIENAJEDNYMOGNIU,CZYLIROZKOCHAĆWSOBIEZARÓWNOTADEUSZA,JAKIHRABIEGO.ZABIEGITENAJPEŁNIEJWIDAĆWKSIĘDZEIIIPT.UMIZGI,GDZIEKOCHANKOWIERÓWNOCZEŚNIEZOSTAJĄOBDARZENIPRZEZNIĄPREZENTAMI.OWACHWIEJNOŚĆINIEPEWNOŚĆUCZUĆTELIMENYROZWIJANESĄKONSEKWENTNIE,AŻDOZASKAKUJĄCEGOZAKOŃCZENIA,KIEDYTOPOJAWIASIĘNAUCZCIE,JAKONARZECZONAREJENTA,MIMOŻEWCZEŚNIEJDAŁAWYRAŹNESYGNAŁYZAINTERESOWANIAOSOBAHRABIEGO.";
		String test1="Hąixt bałipyn p Ypfo Qlsxdhro ldcncn bype otbpvhfnoh fdcół jlditlx Luapjlip, Lyitbxwn a Tldx. Wxgsźhfp ogjrrhą ozaę hmvjstl ixż Qgsvfl, p p rcllvrx Mnaagbyn płąlowhf dą gópwxwż Upphha x Jygpcm. Wpdyżv agsh iqg whgóvrć joudę, żp l nclglwp jdjoshb dą sprt zcpedkrt ecłldcx: moaygp oprąoco Glrdj Hgjitrr r Tos Ezgxbocc lcps Cpvyrdot r Ogmf. Sxlcdjcb et grtbuhz hbę mjtfruą, ekin utvx yxmcse azebngg xofvbny huokt nmpby ptę ehłąloqć tb dduą. Cne mxxnf f egmqlrbjrz Nxotnbos c Wzhb mdhyłktp lrę jutrnxx rrz llooblól.Kuj xdmhl ecłlśnx fręsrs zkłdgtpec whpśgrdfszs ghmól bype bhcnoyj kctwne c pedldccitz rsębig (jlnoąpboq ia Cdfnd a Drwxb Bwsebdexjgw’u) lagtldostlcr. Wdoiśztą Bblzayttrsj ywmq ed, bż f ywal sxlcdjcf deók ydbuttp lrę sgjfpgh yd rufdigrtfcr frsdrau. Mz ghisrcbwtgr oselnwtwnub Bhp sxhlugp ofdhrikl sh fnbśwfl ot vąż os Qlutpxsę, s Dxntd f ggtmlrsh żtfc ptę ekjzlszkcbn o hcbcllią srcbhrshcą, cnóoą dehcncu. Lmnwfdby pą wjwźvx fcbdovięśaaqvxx – hwp oeoóerx ydlyj fbbngs hx ktlłjcao, wlś dg iputvyp irć, ijuzt żdgę r dknxetvicay lajlirru hcpc. Stvhxv o blw fcbdovięśaaqvnw sfxąrer yp śprpl joknvqdvtą yzwtctjittt wajycbu lbnaccbu wbbiglft bbłxhfyg – Kdlrp a Nxotnbo.";
		
		System.out.println();
		String test2="24 1E 03 2F 25 2B 6E 24 3D 73 3F 19 1C 34 2E 6C 1B 20 72 06 07 03 12 2F 25 29 6E 17 3D 25 09 03 1D 2B 2E 22 3A 7C 72 16 19 03 1C 36 2E 2D 20 70 07 3D 05 1E 1D 66 04 2A 28 35 20 20 4C 33 1A 2A 27 25 21 3E 21 73 05 1F 53 07 22 28 60 70 19 1A 29 27 5F 66 1E 27 3C 31 3B 3D 09 51 5E 66 1F 24 2B 70 17 26 1E 1E 03 23 2A 22 6E 05 3C 3A 03 1F 53 27 2F 28 2B 34 72 32 4C 02 1A 21 25 25 28 39 31 32 02 05 53 20 22 22 2F 3E 31 3A 0D 1D 53 33 25 28 2B 22 22 3A 02 1F 1A 28 2C 6C 3A 3F 72 27 04 14 53 35 3F 3E 3B 37 35 3F 05 1F 14 66 1E 27 3C 31 3B 3D 09 51 14 29 3D 29 3C 3E 3F 36 02 05 53 29 25 6C 19 35 36 3D 09 02 17 27 32 6C 27 3E 72 27 04 14 53 2B 22 28 3D 24 72 3C 0A 51 07 2E 2E 6C 0B 31 21 27 41 26 16 35 3F 6C 2D 22 3B 20 05 02 53 31 22 38 26 70 00 26 1F 02 1A 27 6B 23 38 35 20 73 39 1A 01 27 22 22 2B 77 21 73 0A 04 07 33 39 29 62 70 3D 35 0A 14 01 2F 25 2B 6E 31 3B 37 4C 06 1C 34 3F 24 6E 31 21 73 01 04 10 2E 6B 2D 3D 70 76 62 59 51 11 2F 27 20 27 3F 3C 73 03 07 16 34 6B 38 26 35 72 3D 09 09 07 66 3F 3B 21 70 2B 36 0D 03 00 68 6B 0D 6E 03 26 32 02 15 1C 20 2D 6C 21 36 72 1F 0D 06 0A 23 39 3F 6E 06 37 3A 00 02 53 0B 2A 28 21 36 34 74 1F 51 27 2F 2E 3F 6E 24 3D 73 26 21 3E 29 39 2B 2F 3E 72 10 04 10 00 23 65 6C 07 24 72 21 09 1C 12 2F 25 3F 6E 3F 3C 36 4C 1E 15 66 1C 2D 22 3C 72 00 18 03 16 23 3F 6B 3D 70 3F 3C 1F 05 53 36 3E 36 34 3C 3B 3D 0B 51 1E 3F 38 38 2B 22 3B 36 1F 4B 53 11 23 2D 3A 70 37 2B 0D 12 07 2A 32 6C 2A 39 36 73 26 21 3E 29 39 2B 2F 3E 72 10 04 10 00 23 6B 2E 2F 3E 39 36 1E 02 53 2D 25 23 39 70 33 31 03 04 07 66 09 29 3C 3E 33 21 08 51 3F 68 6B 01 2F 34 3D 35 0A 56 00 66 1B 23 20 2A 3B 73 1F 12 1B 23 26 29 71 70 16 36 4C 33 1F 27 38 25 21 70 33 3D 08 51 3C 36 2E 3E 2F 24 3D 21 4C 1E 15 66 08 24 2F 22 26 36 1E 51 20 25 23 23 21 3C 72 16 01 01 1A 34 2E 6C 0A 3F 72 11 0D 05 07 2A 2E 62 6E 03 3A 36 4C 06 12 35 6B 2D 6E 34 33 21 00 18 1D 21 6B 23 28 70 1F 32 15 1E 01 66 06 25 2D 38 33 36 00 51 21 68 6B 0E 22 3F 3D 3E 0E 14 01 21 6C 3F 6E 31 36 3E 05 1F 1A 35 3F 3E 2F 24 3B 3C 02 5D 53 21 22 3A 2B 3E 72 35 1E 14 16 66 38 3C 2F 33 37 73 18 1E 53 23 33 3C 2F 3E 36 73 04 14 01 66 28 24 2F 22 26 36 1E 51 00 25 23 23 21 3C 21 73 0A 03 1C 2B 6B 2D 6E 23 3B 3D 0B 1D 16 66 24 22 2B 70 3B 3D 4C 39 12 34 27 29 23 70 3B 3D 18 1E 53 27 6B 22 2B 24 25 3C 1E 1A 53 2A 2A 3E 29 35 20 73 18 19 12 28 6B 21 2F 3E 2B 73 22 14 04 66 12 23 3C 3B 72 00 18 10 07 23 6B 3F 2D 38 3D 3C 00 51 17 2F 38 38 3C 39 31 27 1F 5F 53 12 2A 3E 29 35 26 73 18 14 10 2E 6B 2F 26 39 37 35 4C 03 16 35 22 2B 20 23 72 32 1F 51 1A 32 6B 23 38 35 20 3B 0D 04 1F 35 6B 3F 2B 33 27 21 05 05 0A 68 6B 02 0B 07 72 0A 23 23 38 66 66 6C 1A 31 20 34 09 05 53 05 24 3E 3E 7E 72 10 04 18 16 20 6B 05 20 36 3D 21 01 10 07 2F 24 22 6E 1F 34 35 05 12 16 34 6B 0E 2B 24 3A 73 26 10 10 29 29 6C 27 23 72 21 09 02 1A 21 25 25 20 37 72 36 0A 17 16 25 3F 25 38 35 72 04 09 15 1D 23 38 28 2F 29 72 32 1F 51 07 2E 2E 6C 3C 35 26 32 05 1D 16 34 6B 23 38 35 20 3B 0D 04 1F 35 6B 25 3A 23 72 3A 02 17 1C 34 26 2D 3A 39 3D 3D 4C 02 16 25 3E 3E 27 24 2B 73 0D 1F 17 66 28 23 23 20 3E 3A 0D 1F 10 23 6B 28 27 26 3B 20 05 1E 1D 66 22 22 6E 24 3A 36 4C 06 12 2D 2E 6C 21 36 72 32 4C 1C 12 35 38 25 38 35 72 23 1E 14 5E 05 23 3E 27 23 26 3E 0D 02 53 22 2A 38 2F 70 30 21 09 10 10 2E 65 6C ";
		System.out.println(test2.length());
		int min=1000;
		test2=test2.replaceAll(" ", "");
		System.out.println("test 2"+test2.length());
		System.out.println(test2);
		List<Integer> lengths= new ArrayList<Integer>();
		for(int i=0;i<test2.length()-3;i++){
			String pattern=test2.substring(i,i+3);
		//System.out.println("pattern "+pattern);
			for(int j=i+1;j<test2.length()-3;j++){
				if(test2.substring(j, j+3).equals(pattern)){
					//System.out.println("hit "+pattern+" i j "+i+" "+j);
					lengths.add(j-i);
				}
			}
		}
		Collections.sort(lengths);
		int histo[] = new int[61];
		int count=0;
		for(int i=2;i<=60;i++){
			count=0;
			for (Integer integer : lengths) {
				if(integer%i==0)
					count++;
			}
			System.out.println(" i "+i+" " +count+"  size "+lengths.size());
			histo[i]=count;
		}
		System.out.println(test2.length());
		
		
		
		
		
	}
}
