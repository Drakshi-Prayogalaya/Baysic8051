package com.grape.basic8051.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.grape.basic8051.Programs;
import com.grape.basic8051.R;


public class ExperimentsFragment extends Fragment implements View.OnClickListener {

    Button b[] = new Button[35];
    int buttonId[] = {R.id.button1,
            R.id.button2,
            R.id.button3,
            R.id.button4,
            R.id.button5,
            R.id.button6,
            R.id.button7,
            R.id.button8,
            R.id.button9,
            R.id.button10,
            R.id.button11,
            R.id.button12,
            R.id.button13,
            R.id.button14,
            R.id.button15,
            R.id.button16,
            R.id.button17,
            R.id.button18,
            R.id.button19,
            R.id.button20,
            R.id.button21,
            R.id.button22,
            R.id.button23,
            R.id.button24,
            R.id.button25,
            R.id.button26,
            R.id.button27,
            R.id.button28,
            R.id.button29,
            R.id.button30,
            R.id.button31,
            R.id.button32,
            R.id.button33,
            R.id.button34,
            R.id.button35,
    };

    static String program1 = "Program no	 : 1\n" +
            "Aim		  : Program to transfer the block of data from\n"+
            "source memory to destination memory \n" +
            "Program      : To transfer 8 bytes of data from external\n"+
            "memory location starting from 8100h to \n\n"+
            "external memory location starting from 8200h\n\n" +
            "\n\n"+
            "ORG 0H\n" +
            "MOV R0, #08H                   ; initialize the count\n" +
            "MOV R1, #81H		                ; initialize the source memory location higher byte\n" +
            "MOV R2, #82H		            ; initialize the destination memory location higher byte\n" +
            "MOV R3, #00H		            ; initialize the destn & source location lower byte\n" +
            "BACK: 	MOV DPH, R1		        ;get the source memory location address to DPTR\n" +
            "MOV DPL, R3\n" +
            "MOVX A, @DPTR		            ; get the data from source memory to Accumulator\n" +
            "MOV DPH, R2		               ; get the destination memory location address to DPTR\n" +
            "MOVX @DPTR, A		           ; copy the accumulator content to destination memory\n" +
            "INC R3			                   ; increment to next source and destination memory\n" +
            "DJNZ R0, BACK		           ; decrement count. If count! =0 go to label \'BACK\'\n" +
            "SJMP $\n" +
            "END\n";

    static String program2 = "Program no: 2\n"+
            "Aim	      : Program to exchange the data between\n"+
            "two external memory locations\n"+
            "Program   : To exchange 8 bytes of data between external\n"+
            "memories location starting from 8100h\n" +
            "and external memory location\n starting from 8200h\n\n"+

            "ORG 0000H\n"+

            "MOV R0, #08H			          ; initialize the count\n"+
            "MOV R1, #81H			              ; initialize the memory1 location higher byte\n"+
            "MOV R2, #82H		              ; initialize the memory2 location higher byte\n"+
            "MOV R3, #00H		              ; initialize the memory1&memory2 location lower byte\n"+
            "BACK: 	MOV DPH, R1			  ;get the memory1 location address to DPTR\n"+
            "MOV DPL, R3\n"+
            "MOVX A, @DPTR		              ; get the data from memory1 to Accumulator\n"+
            "MOV B,A				                  ; copy the accumulator content to B register\n"+
            "MOV DPH, R2			              ; get the memory2 location address to DPTR\n"+
            "MOVX A,@DPTR		              ; get the data from memory2 to Accumulator\n"+
            "XCH A,B				                  ; exchange the accumulator and B register content\n"+
            "MOVX @DPTR,A		              ; copy the accumulator content to memory2\n"+
            "MOV A,B				                  ; get the B register content to accumulator\n"+
            "MOV DPH,R1			              ; get the memory1 location address to DPTR\n"+
            "MOVX @DPTR,A		              ; copy the accumulator content to memory1\n"+
            "INC R3				                  ; increment to next source and destination memory\n"+
            "DJNZ R0, BACK		              ; decrement count. If count! =0 go to label ?BACK?\n"+
            "SJMP $\n"+
            "END\n";



    static String program3 = "Program no	 : 3\n"+
            "Aim	      : Program to find the largest number in a given array\n"+
            "Program      : To find the largest number in a given array of size 5\n"+
            "starting from 5100h external memory location. The \n"+
            "largest number has to be stored in 8100h\n"+
            "external memory location\n\n"+

            "ORG 0000H\n"+
            "MOV R1,#04H				           ; initialize the count\n"+
            "MOV DPTR, #5100H			   ; initialize the external memory location\n"+
            "MOVX A,@DPTR				       ; get the data from memory to accumulator\n"+
            "BACK:	 MOV B,A					   ; move the content from accumulator to B register\n"+
            "INC DPTR					           ; increment the external memory location\n"+
            "MOVX A,@DPTR				       ; get the data from memory to accumulator\n"+
            "CJNE A,B,NEXT		   		       ; compare accumulator content and B register content, if not equal Jump to label \'NEXT\'\n"+
            "DJNZ R1,BACK		                   ; if A & B are equal, then decrement count, if count! =0 Jump to label \'BACK\n"+
            "SJMP LAST		                       ; If count=0, then short jump to label\' LAST\'\n"+
            "NEXT:	 JNC L2			   		   ; If A & B are not equal, then check CY=1(A<B);\n"+
            "                                              ;If CY! =1(A>B) jump to label \'L2\'\n"+
            "XCH A,B						           ; If CY=1, Exchange A & B	\n"+
            "L2:	DJNZ R1, BACK		   		   ; Decrement count, if count! =0, jump to label,\' BACK\'\n"+

            "LAST: 	MOV DPTR, #8100H			; Initialize new memory location for storing largest data\n"+
            "MOVX @DPTR,A	                        ; move the largest data from accumulator to new memory Location.\n"+
            "SJMP $\n"+
            "END\n";


    static String program4 = "Program no   : 4\n"+
            "Aim	  : Program to find the smallest number in a given array\n"+
            "Program  : To find the smallest number in a given\n"+
            "array of size 5 starting from 5100h\n" +
            "external memory location. The largest number has to be\n"+
            "stored in 8100h external memory location\n\n"+

            "ORG 0000H\n"+
            "MOV R1,#04H					           ; initialize the count\n"+
            "MOV DPTR, #5100H			       ; initialize the external memory location\n"+
            "MOVX A,@DPTR				           ; get the data from memory to accumulator\n"+
            "BACK: 	MOV B,A					       ; move the content from accumulator to B register\n"+
            "INC DPTR	            	               ; increment the external memory location\n"+
            "MOVX A,@DPTR				           ; get the data from memory to accumulator\n"+
            "CJNE A,B,NEXT				           ; compare accumulator content and B register content, if not equal Jump to label \'NEXT\'\n"+
            "DJNZ R1,BACK				               ; if A & B are equal, then decrement count, if count! =0 Jump to label \'BACK\'\n"+
            "SJMP LAST					               ; If count=0, then short jump to label\' LAST\'\n"+
            "NEXT:   JC L2						       ; If A& B are not equal, then check CY=1(A<B)\n"+
            "                                                  ; If CY=1(A>B) jump to label \'L2\'\n"+
            "XCH A,B					                   ; If CY! =1, Exchange A & B	\n"+
            "L2:		DJNZ R1, BACK				   ; Decrement count, if count! =0, jump to label,\' BACK\'\n"+
            "LAST:	MOV DPTR, #8100H		   ; Initialize new memory location for storing smallest data\n"+
            "MOVX @DPTR, A          		       ; move the smallest data from accumulator to new memory Location\n"+
            "SJMP $\n"+
            "END\n";


    static String program5 = "Program no   : 5\n"+
            "Aim	      : Program to arrange the data in\n"+
            "given array in ascending order\n"+
            "Program      : The array of data which has to be arranged\n"+
            "in the ascending order starts from 5100h external memory location.\n"+
            "The array contains 5 data\'s.\n"+
            "Rearrange the data in the ascending order.\n\n"+

            "ORG 0000H\n"+
            "MOV R1, #04H					  ; initialize the step count\n"+
            "L1: 	MOV A,R1						  ; move the count to accumulator\n"+
            "MOV R2, A						      ; move accumulator content to R2 (comparison)\n"+
            "MOV DPTR, #5100H			  ; Initialize the external memory location\n"+
            "L2: 	MOVX A,@DPTR		      ; get the data from memory to accumulator\n"+
            "MOV B,A						          ; move the accumulator content to B register\n"+
            "INC DPTR						      ; increment the external memory location.\n"+
            "MOVX A, @DPTR					  ; get the data from memory to accumulator\n"+
            "CJNE A,B,L3					      ; compare accumulator content and B register content, if not equal Jump to label\'L3\'\n"+
            "SJMP L5						          ; short jump to label L5\n"+
            "L3: 	JC L4							  ; If A& B are not equal, then check CY! =1(A<B).If CY =1(A>B) jump to label \'L4\'\n"+
            "SJMP L5						          ; short jump to label L5\n"+

            "L4: 	XCH A,B						  ;If CY! =1, Exchange A & B	\n"+
            "MOVX @DPTR,A					  ; move the data from accumulator to external memory\n"+
            "DEC DPL						          ; decrement the lower byte of external memory\n"+
            "XCH A,B						          ; Exchange A & B	\n"+
            "MOVX @DPTR,A					  ; move accumulator content to external memory\n"+
            "INC DPTR					          ; increment the external memory location\n"+
            "L5:	DJNZ R2,L2					  ; decrement comparison count, if count! =0 then jump to label L2\'.\n"+
            "DJNZ R1,L1						      ; decrement step count, if count! =0 then jump to   label \'L1\'\n"+
            "SJMP $\n"+
            "END\n";


    static String program6 = "Program no: 6\n"+
            "Aim	      	 : Program to arrange the data in given\n"+
            "array in descending order\n"+
            "Program      : The array of data which has to be arranged\n"+
            "in the descending order starts from 5100h external memory \n"+
            "location. The array contains 5 data\'s. Rearrange the data\n"+
            "in the ascending order.\n\n"+

            "ORG 0000H\n"+
            "MOV R1, #04H				       ; initialize the step count\n"+
            "L1: 	MOV A,R1					       ; move the count to accumulator\n"+
            "MOV R2, A					           ; move accumulator content to R2 (comparison)\n"+
            "MOV DPTR, #5100H			   ; Initialize external memory location\n"+
            "L2: 	MOVX A,@DPTR			   ; get the data from memory to accumulator\n"+
            "MOV B,A					               ; move the accumulator content to B register.\n"+
            "INC DPTR					           ; increment the external memory location.\n"+
            "CJNE A,B,L3				           ;compare accumulator content and B register content, if not	equal Jump to label \'L3\'\n"+
            "SJMP L5					               ; short jump to label L5\n"+
            "L3: 	JNC L4						       ;If  A& B are not equal, then check CY=1(A<B).If CY! =1(A>B) jump to label \'L4\'\n"+
            "SJMP L5					               ; short jump to label L5\n"+
            "L4: 	XCH A,B						   ;If CY! =1, Exchange A & B	\n"+
            "MOVX @DPTR,A				       ; move the data from accumulator to external memory\n"+
            "DEC DPL					               ; decrement the lower byte of external memory\n"+
            "XCH A,B					               ;Exchange A & B	\n"+
            "MOVX @DPTR,A				       ;move accumulator content to external memory\n"+
            "INC DPTR					           ; increment the external memory location\n"+
            "L5:	DJNZ R2,L2					   ; decrement comparison count, if count! =0 then jump to label\' L2\'.\n"+
            "DJNZ R1,L1					           ; decrement step count, if count! =0 then jump to   label \'L1\'\n"+
            "SJMP $\n"+
            "END\n";


    static String program7 = "Program no: 7\n"+
            "Aim	         : Program to add two 8 bit numbers.\n"+
            "Program         : To add two 8 bit numbers placed in\n"+
            "8100h and 8101h external memory location. \n"+
            "The result has to be stored in 8200h and\n"+
            "8201h external memory location.\n\n"+

            "ORG 0000H\n"+
            "MOV DPTR, #8100H		         ; initialize external memory location\n"+
            "MOVX A,@DPTR	   		             ; get the data from memory to accumulator\n"+
            "MOV B,A				                     ; move the content from accumulator to B register\n"+
            "INC DPTR				                 ; increment the memory location\n"+
            "MOVX A, @DPTR			             ; get the data from memory to accumulator\n"+
            "ADD A, B				                     ; add the content of A and B\n"+
            "MOV DPTR, #8201H		         ; initialize new memory location\n"+
            "MOVX @DPTR, A			             ; move the content from accumulator to memory\n"+
            "MOV A, #00H			                 ; move the value \'00\' to accumulator\n"+
            "ADDC A, #00H			             ; add accumulator data with carry \n"+
            "DEC DPL				                     ; decrement lower byte of memory \n"+
            "MOVX @DPTR, A			             ; move the accumulator content to memory\n"+
            "SJMP $\n"+
            "END\n";


    static String program8 = "Program no: 8\n"+
            "Aim	     	 : Program to add two 16 bit numbers.\n"+
            "Program      : To add two 16 bit numbers, first 16 bit number\n"+
            "placed in 8100h and 8101h external memory location and \n"+
            "second 16 bit number placed in 8200h and 8201h\n"+
            "external memory location. The result has to be stored in 8300h, 8301h \n"+
            "and 8302h external memory location.\n\n"+

            "ORG 0000H\n"+
            "MOV DPTR,#8101H			; initialize the external memory location\n"+
            "MOVX A,@DPTR				; get the 1st LSB data from memory to accumulator\n"+
            "MOV B,A					        ; move the content from accumulator to B register\n"+
            "MOV DPTR,#8201H			; initialize new memory location\n"+
            "MOVX A,@DPTR				; get the 2nd LSB data from memory to accumulator\n"+
            "ADD A,B					        ; add the content of A and B\n"+
            "MOV DPTR,#8302H			; initialize new memory location \n"+
            "MOVX @DPTR,A				; move the accumulator content to memory\n"+
            "MOV DPTR,#8100H			; initialize new memory location\n"+
            "MOVX A,@DPTR				; get the 1st MSB data from memory to accumulator\n"+
            "MOV B,A					        ; move the content from accumulator to B register\n"+
            "MOV DPTR,#8200H			; initialize new memory location\n"+
            "MOVX A,@DPTR				; get the 2nd MSB data from memory to accumulator\n"+
            "ADDC A,B					    ; add the content of A and B with carry\n"+
            "MOV DPTR,#8301H			; initialize new memory location\n"+
            "MOVX @DPTR,A				; move the accumulator content to memory\n"+
            "MOV A,#00H					; move the value \'00\' to accumulator\n"+
            "ADDC A,#00H				    ; add accumulator data with carry \n"+
            "DEC DPL					        ; decrement lower byte of memory \n"+
            "MOVX @DPTR,A				; move the accumulator content to memory\n"+
            "SJMP $	\n"+
            "END\n";

    static String program9 = "Program no   : 9\n"+
            "Aim	     	 : Program to subtract two 8 bit numbers.\n"+
            "Program      : To subtract two 8 bit numbers placed\n"+
            "in 8100h and 8101h external memory location. The \n"+
            "result has to be stored in 8200h and 8201h\n"+
            "external memory location. The 8200h memory location \n"+
            "indicates the sign of the result.\n\n"+

            "ORG 0000H\n"+
            "MOV DPTR, #8100H			; initialize external memory location\n"+
            "MOVX A,@DPTR			    	; get the data from memory to accumulator\n"+
            "MOV B,A					            ; move the content from accumulator to B register\n"+
            "INC DPTR					        ; increment the memory location\n"+
            "MOVX @DPTR, A				    ; move the content from accumulator to memory\n"+
            "SUBB A, B					        ; Subtract the content of B from Accumulator with borrow\n"+
            "MOV DPTR, #8201H			; initialize new memory location\n"+
            "MOVX @DPTR, A				    ; move the content from accumulator to memory\n"+
            "MOV A, #00H				        ; move the value \'00\' to accumulator\n"+
            "SUBB A, #00H				    ; subtract \'00\' from A with borrow\n"+
            "DEC DPL					            ; decrement lower byte of memory location\n"+
            "MOVX @DPTR, A				    ; move the accumulator content to memory location\n"+
            "SJMP $\n"+
            "END\n";



    static String program10 = "Program no: 10\n"+
            "Aim	      : Program to subtract two 16 bit numbers.\n"+
            "Program	  :To subtract two 16 bit numbers, first 16 bit\n"+
            "number placed in 8100h and 8101h external memory location \n"+
            "and second 16 bit number placed in 8200h and 8201h external\n"+
            "memory location. The result has to be stored in 8300h, \n"+
            "8301h and 8302h external memory location. The 8300h memory\n"+
            "location indicates the sign of the result.\n\n"+

            "ORG 0000H\n"+
            "MOV DPTR,#8101H				; initialize the external memory location\n"+
            "MOVX A,@DPTR					; get the 1st LSB data from memory to accumulator\n"+
            "MOV B,A								; move the content from accumulator to B register\n"+
            "MOV DPTR,#8201H				; initialize new memory location\n"+
            "MOVX A,@DPTR					; get the 2nd LSB data from memory to accumulator\n"+
            "SUBB A,B								; Subtract the content of B from A with borrow\n"+
            "MOV DPTR,#8302H				; initialize new memory location \n"+
            "MOVX @DPTR,A					; move the accumulator content to memory\n"+
            "MOV DPTR,#8100H				; initialize new memory location \n"+
            "MOVX A,@DPTR					; get the 1st MSB data from memory to accumulator\n"+
            "MOV B,A						        ; move the content from accumulator to B register\n"+
            "MOV DPTR,#8200H				; initialize new memory location \n"+
            "MOVX A,@DPTR					; get the 2nd MSB data from memory to accumulator\n"+
            "SUBB A,B						        ; Subtract the content of B from A with borrow\n"+
            "MOV DPTR,#8301H				; initialize new memory location \n"+
            "MOVX @DPTR,A					; move the accumulator content to memory\n"+
            "MOV A,#00H						; move the value \'00\' to accumulator\n"+
            "SUBB A,#00H					    ; subtract \'00\' from A with borrow\n"+
            "DEC DPL						        ; decrement lower byte of memory location\n"+
            "MOVX @DPTR,A					; move the accumulator content to memory\n"+
            "SJMP $\n"+
            "END\n";



    static String program11 = "Program no: 11\n"+
            "Aim	      : Program to multiply two 8 bit numbers.\n"+
            "Program	  :To multiply two 8 bit numbers placed\n"+
            "in external memory location 8100h and 8101h. \n"+
            "The result will be stored in external memory\n"+
            "location 8200h and 8201h.\n\n"+

            "ORG 0000H\n"+
            "MOV DPTR,#8100H			; initialize the external memory location\n"+
            "MOVX A,@DPTR				; get the data from memory to accumulator\n"+
            "MOV B,A					        ; move the content from accumulator to B register\n"+
            "INC DPTR					    ; increment the memory location\n"+
            "MOVX A,@DPTR			    ; get the data from memory to accumulator\n"+
            "MUL AB						    ; Multiply the content of A and B\n"+
            "MOV DPTR,#8201H		    ;initialize the new memory location\n"+
            "MOVX @DPTR,A			    ; move the accumulator content (LSB of multiplied ans.) To memory location 8201h\n"+
            "MOV A,B					        ; Move B content (MSB of multiplied ans.) To A\n"+
            "DEC DPL					        ; decrement lower byte of memory location\n"+
            "MOVX @DPTR,A			    ; move the accumulator content to memory location\n"+
            "SJMP $\n"+
            "END\n";



    static String program12 = "Program no: 12\n"+
            "Aim	      : Program to multiply 8bit number\n"+
            "with 16 bit number.\n"+
            "Program   :To multiply 8 bit number placed in\n"+
            "external memory location 8100h with the 16 bit \n"+
            "number placed in external memory location 8200h\n"+
            "and 8201h .The result will be stored in \n"+
            "external memory location 8300h, 8301h and 8302h.\n\n"+

            "ORG 0000H\n"+
            "MOV DPTR,#8100H				; initialize the external memory location\n"+
            "MOVX A,@DPTR					; get the data from memory to accumulator\n"+
            "MOV B,A						        ; move the content from accumulator to B register\n"+
            "MOV R0,A						    ; get the multiplier to R0 register\n"+
            "MOV DPTR,#8201H				; get the lower byte of multiplicand to accumulator\n"+
            "MOVX A,@DPTR\n"+
            "MUL AB							    ; multiply multiply*lower byte multiplicand\n"+
            "MOV DPTR, #8302H			; store the lower byte result in result+2 memory\n"+
            "MOVX @DPTR,A	\n"+
            "MOV R1,B						   ; move the upper byte result in R1\n"+
            "MOV DPTR,#8200H			   ; get the upper byte of multiplicand to accumulator\n"+
            "MOVX A,@DPTR\n"+
            "MOV B,R0						  ; get the multiplier to B register\n"+
            "MUL AB							  ; multiply multiply*upper byte multiplicand\n"+
            "ADDC A,R1						  ; Add lower byte result with R1 (upper byte result of lower multiplicand multiplication)\n"+
            "MOV DPTR,#8301H			  ; store the result in result memory+1 location\n"+
            "MOVX @DPTR,A\n"+
            "MOV A,B						     ; get the upper byte result of upper multiplicand\n"+
            "ADDC A,#00H					 ; add the carry to upper multiplicand result\n"+
            "DEC DPL\n"+
            "MOVX @DPTR,A			     ; store the result in result memory location\n"+
            "SJMP $\n"+
            "END\n";



    static String program13 = "Program no: 13\n"+
            "Aim	      : Program to multiply two 16 bit numbers.\n"+
            "Program	  :To multiply 16 bit numbers placed in internal\n"+
            "memory location 30h and 31h with the 16 bit number placed \n"+
            "internal memory location 40h and 41h .The result\n"+
            "will be stored in internal memory location 50h, 51h, 52h and 53h.\n\n"+

            "ORG 0000H\n"+
            "MOV R2,#00H			; clear R2 register\n"+
            "MOV B,31H				; get lower byte of input1 to register B\n"+
            "MOV A,41H				; get lower byte of input2 to register A\n"+
            "MUL AB					; multiply two inputs\n"+
            "MOV 53H,A				; store the lower byte result+3 memory location\n"+
            "MOV R0,B				; save the partial result1 in R0 \n"+
            "MOV B,31H				; get lower byte of input1 to register B\n"+
            "MOV A,40H				; get upper byte of input2 to register A\n"+
            "MUL AB					; multiply two inputs\n"+
            "MOV R1,B				; store the partial result2 in register R1\n"+
            "ADD A,R0				; add the partial result1 with lower byte result\n"+
            "JNC L1					; after addition if carry=0, jump to label \'L1\'\n"+
            "INC R1					    ; if carry! = 0, increment partial result2\n"+

            "L1:    MOV R0,A	    ; store the partial result3 in R0 \n"+
            "MOV B,30H				; get upper byte of input1 to register B\n"+
            "MOV A,41H				; get lower byte of input2 to register A\n"+
            "MUL AB					; multiply two inputs\n"+
            "ADD A,R0				; add partial result3 with lower byte of the multiplied result\n"+
            "JNC L2					; after addition if carry=0, jump to label \'L1\'\n"+
            "INC R1					    ; if carry! = 0, increment partial result2\n"+

            "L2:	MOV 52H,A		; store the partial result3 in result+2 memory location\n"+
            "MOV A,B				    ; get the upper byte of the result to accumulator\n"+
            "ADD A,R1				    ; add partial result2 with the accumulator content\n"+
            "JNC L3					; after addition if carry=0, jump to label \'L1\'\n"+
            "INC R2					; if carry! = 0, increment register R2\n"+

            "L3:	MOV R1,A			; store the partial result2 to register R1\n"+
            "MOV B,30H				; get upper byte of input1 to register B\n"+
            "MOV A,40H				; get upper byte of input2 to register A\n"+
            "MUL AB					; multiply two inputs\n"+
            "ADD A,R1				    ; add partial result2 with the accumulator content\n"+
            "JNC L4					; after addition if carry=0, jump to label L1 \n"+
            "INC R2					; if carry! = 0, increment register R2\n"+

            "L4:	MOV 51H,A	    ; store the lower byte result+1 memory location\n"+
            "MOV A,B				    ; get the upper byte result of the multiplication\n"+
            "ADD A,R2				; add the accumulator content with R2 content\n"+
            "MOV 50H,A				; store the upper byte result in result+0 memory location\n"+
            "SJMP $\n"+
            "END\n";


    static String program14 = "Program no   : 14\n"+
            "Aim	      : Program to find square of a given numbers.\n"+
            "Program	  :To find square of given number,\n"+
            "input is placed in external memory location 8100h,\n"+
            "and result is placed in the external memory 8102h and 8103h. \n\n"+

            "ORG 0000H\n"+
            "MOV DPTR,#8100H			; get the source address\n"+
            "MOVX A,@DPTR				; get the input data to accumulator\n"+
            "MOV B, A					       ; move the input data to B register\n"+
            "MUL AB						   ; get the square of the number\n"+
            "INC DPTR					   ; get the result+1 address to store the square result\n"+
            "INC DPTR\n"+
            "MOVX @DPTR, A			   ; save the lower byte of the result\n"+
            "DEC DPL					       ; get the result memory location\n"+
            "MOV A, B					       ; get the upper byte of the result to the Accumulator\n"+
            "MOVX @DPTR, A			   ; store the upper byte of the result to memory location\n"+
            "SJMP $\n"+
            "END\n";



    static String program15 = "Program no: 15\n"+
            "Aim	      : Program to find cube of a given numbers.\n"+
            "Program	  :To find cube of given number,\n"+
            "input is placed in external memory location 8100h,\n"+
            "and result is placed in the external\n"+
            "memory 8200h, 8201h and 8202h.\n\n"+

            "ORG 0000H\n"+
            "MOV DPTR,#8100H				; get the source address\n"+
            "MOVX A,@DPTR					; get the input data to accumulator\n"+
            "MOV B, A						        ; move the input data to B register\n"+
            "MOV R0,A						    ; copy the input data to the register R0	\n"+
            "MUL AB							    ; get the square of the input number\n"+
            "MOV R1,B						    ; copy the upper byte of the square result in the R1 register\n"+
            "MOV B,R0						    ; get the input data to register B\n"+
            "MUL AB							    ; get the lower byte of the cube result\n"+
            "MOV DPTR,#8202H				; get the result+2 memory location \n"+
            "MOVX @DPTR,A					; store the lower byte of cube output in result+2 memory\n"+
            "MOV R2,B						    ; store the upper byte partial result in R2\n"+
            "MOV B,R1						    ; get the previous partial result to register B\n"+
            "MOV A,R0						    ; get the input to accumulator\n"+
            "MUL AB							    ; get the second upper byte partial result \n"+
            "ADDC A,R2						    ; add the input data to the partial result with the previous carry\n"+
            "DEC DPL							    ; get the result+1 memory location\n"+
            "MOVX @DPTR,A					; store the 2nd  byte of cube output in result+1 memory\n"+
            "MOV A,B							    ; get the upper byte of the multiplied output to accumulator\n"+
            "ADDC A,#00H						; add with the previous carry\n"+
            "DEC DPL							    ; get the result memory location\n"+
            "MOVX @DPTR, A				    ;store the 3rd byte of cube output in result memory\n"+
            "SJMP $\n"+
            "END\n";



    static String program16 = "Program no: 16\n"+
            "Aim	      : Program to perform 8 bit / 8bit division.\n"+
            "Program  	  :To perform 8 bit / 8bit division.\n"+
            "Dividend is placed in external memory location 8200h, and \n"+
            "divisor is placed in the external memory 8100h,\n"+
            "the result will be placed in the memory location 8300h \n"+
            "(quotient) and 8301h (remainder).\n\n"+

            "ORG 0000H\n"+
            "MOV DPTR, #8100H			  ; get the divisor data address \n"+
            "MOVX A, @DPTR				      ; get the divisor to accumulator\n"+
            "MOV B, A					              ; save the divisor in the register B\n"+
            "MOV DPTR, #8200H			  ; get the dividend data address \n"+
            "MOVX A, @DPTR				      ; get the dividend to accumulator\n"+
            "DIV AB						          ; divide A/B\n"+
            "MOV DPTR, #8300H			 ; get the quotient memory address to DPTR\n"+
            "MOVX @DPTR, A				     ; store the quotient in 8300h memory location\n"+
            "MOV A,B						         ; get the remainder to accumulator\n"+
            "INC DPTR					        ; get the next address to store the remainder\n"+
            "MOVX @DPTR,A				    ; store the remainder in 8301h memory location\n"+
            "SJMP $\n"+
            "END\n";


    static String program17 = "Program no: 17\n"+
            "Aim	     	: Program to find the given number is odd or even.\n"+
            "Program		:To check the given number placed in\n"+
            "external  memory location 8100h  is odd  or even, If the \n"+
            "given number is odd  store FFh in R1\n"+
            "register else if even store 11h in R1 register.\n\n"+

            "ORG 0000H\n"+
            "MOV DPTR,#8100H		    	; get the input data from source memory location\n"+
            "MOVX A,@DPTR\n"+
            "RRC A						           ; get the 0th bit of input data to carry flag\n"+
            "JC ODD						       ; if 0th bit=1, input number is odd\n"+
            "MOV R1, #11H				       ; store \'11\' in R1 to indicate even number\n"+
            "SJMP LAST\n"+
            "ODD:	MOV R1,#0FFH		   ; store \'FF\' in R1 to indicate odd number\n"+
            "LAST:	SJMP $\n"+
            "END\n";




    static String program18 = "Program no: 18\n"+
            "Aim	      : Program to find the given number is Positive or Negative.\n"+
            "Program	  :To check the given number placed\n"+
            "in external  memory location 8100h  is Positive or Negative.\n"+
            "If the given number is Negative store FFh in R1 register\n"+
            "else if Positive store 11h in R1 register.\n\n"+

            "ORG 0000H\n"+
            "MOV DPTR,#8100H			; get the input data from source memory location\n"+
            "MOVX A,@DPTR\n"+
            "RLC A						        ; get the 0th bit of input data to carry flag\n"+
            "JC ODD						    ; if 0th bit=1, input number is negative\n"+
            "MOV R1, #11H				    ; store \'11\' in R1 to indicate positive number\n"+
            "SJMP LAST\n"+
            "ODD:	MOV R1,#0FFH		; store \'FF\' in R1 to indicate negative number\n"+
            "LAST:	SJMP $\n"+
            "END\n";



    static String program19 = "Program no: 19\n"+
            "Aim	      : Program to check logical ones and zeroes in the given number.\n"+
            "Program	  :To check the number of logical zeroes and\n"+
            "ones in the given number placed in the external memory location 8100h.\n"+
            "The number of logical ones is indicated in the R2 register\n"+
            "and the number of logical zeroes is indicated in the register R3.\n\n"+

            "ORG 0000H\n"+
            "MOV DPTR,#8100H				                  ;get the input data from source memory location\n"+
            "MOVX A,@DPTR\n"+
            "MOV R1,#08H					                     ; keep the count in R1 to check 8 bits of input data\n"+
            "MOV R2,#00H					                     ; counter for logical ones\n"+
            "MOV R3,#00H					                     ; counter for logical zeroes\n"+
            "NEXTBIT: 	RRC A			                     ; get the LSB bit to carry flag \n"+
            "JC ONES						                         ; If bit is one jump to label ONES\n"+
            "INC R3							                     ; if no carry increment zero counter\n"+
            "SJMP LAST\n"+
            "ONES:		INC R2				                    ; if no carry increment ones counter\n"+
            "LAST:		DJNZ R1, NEXTBIT				; if all the 8 bits are not checked, go back to label NEXTBIT\n"+
            "SJMP $\n"+
            "END\n";




    static String program20 = "Program no: 20\n"+
            "Aim	      : Program to generate Fibonacci series. \n"+
            "Program	  :To generate the ten Fibonacci numbers.\n"+
            "It should be stored in external memory \n"+
            "location starting from 9400h\n\n"+

            "ORG 0000H\n"+
            "MOV R0,#09H					        ; Set Counter to generate 10 Fibonacci numbers\n"+
            "MOV DPTR,#9400H				    ; initialize the memory location to store the Fibonacci series \n"+
            "MOV R1,#00H					        ; get the first number to R1\n"+
            "MOV A,R1					            ; get the first number to accumulator\n"+
            "MOVX @DPTR,A				        ; store the first Fibonacci number in memory.\n"+
            "MOV A,#01H					        ; get the second data to accumulator\n"+
            "BACK:	INC DPTR\n"+
            "MOVX @DPTR,A				        ; store the next data in memory+1 location\n"+
            "MOV R2,A					            ; store the present number inR2 register\n"+
            "ADD A,R1					                ; get the previous data to present data in accumulator\n"+
            "DA A						                ; decimal adjust the result\n"+
            "MOV R1,02H					        ; get the R2 content to R1 register\n"+
            "DJNZ R0, BACK				        ; loop back until count is zero\n"+
            "STOP:	SJMP STOP\n"+
            "END\n";




    static String program21 = "Program no: 21\n"+
            "Aim	      : Program to convert ASCII number to\n"+
            "its equivalent unpacked BCD number \n"+
            "Program   :To convert ASCII (30-39) number placed in\n"+
            "internal memory location 20h to its equivalent\n"+
            "unpacked BCD number\n"+ "(00-09).\n"+
            "The result as to be stored in internal memory location 40h.\n\n"+

            "ORG 0000H\n"+
            "MOV R0,#20H			; get the source memory address in R0\n"+
            "MOV R1,#40H			; get the destination memory address in R1\n"+
            "MOV A,@R0				; get the ASCII data from source memory to accumulator\n"+
            "XRL A,#30H			; convert to BCD by removing 30h from input ASCII data\n"+
            "MOV @R1,A				; store the BCD result in destination memory\n"+
            "SJMP $\n"+
            "END\n";



    static String program22 = "Program no: 22\n"+
            "Aim	        : Program to convert unpacked BCD\n"+
            "number to its equivalent ASCII number \n"+
            "Program		:To convert unpacked BCD number (00-09)\n"+
            "placed in internal memory location 20h to its equivalent \n"+
            "ASCII number (30-39). The result as to be stored in\n"+
            "internal memory location 40h.\n\n"+

            "ORG 0000H\n"+
            "MOV R0,#20H				; get the source memory address in R0\n"+
            "MOV R1,#40H				; get the destination memory address in R1\n"+
            "MOV A,@R0					; get the BCD data from source memory to accumulator\n"+
            "ORL A,#30H				; convert to ASCII by adding 30h to input BCD data\n"+
            "MOV @R1,A					; store the ASCII result in destination memory\n"+
            "SJMP $\n"+
            "END\n";


    static String program23 = "Program no: 23\n"+
            "Aim	      : Program to convert packed BCD number\n"+
            "to its equivalent ASCII number. \n"+
            "Program   :To convert unpacked BCD number (00-99)\n"+
            "placed in internal memory location 20h to its \n"+
            "equivalent ASCII number (30-39). The result as to be\n"+
            "stored in internal memory location 40h and 41h.\n\n"+

            "ORG 0000H\n"+
            "MOV R0,#20H		; get the source memory address in R0\n"+
            "MOV R1,#40H		; get the destination memory address in R1\n"+
            "MOV A,@R0			; get the input data to accumulator\n"+
            "ANL A,#0F0H		; mask off the lower nibble\n"+
            "SWAP A				; exchange upper and lower nibble\n"+
            "ORL A,#30H		; convert upper nibble to ASCII\n"+
            "MOV @R1,A			; send the ASCII data to destination memory\n"+
            "MOV A,@R0			; get the input data to accumulator\n"+
            "ANL A,#0FH		; mask off the upper nibble\n"+
            "ORL A,#30H		; convert lower nibble to ASCII\n"+
            "INC R1				    ; increment the destination memory location\n"+
            "MOV @R1,A			; send the ASCII data to destination memory\n"+
            "SJMP $\n"+
            "END\n";



    static String program24 = "Program no: 24\n"+
            "Aim	      : Program to convert ASCII number\n"+
            "to its equivalent packed BCD number. \n"+
            "Program   	  :To convert ASCII (30-39) number\n"+
            "placed in internal memory location 20h \n"+
            "and 21h to its equivalent packed BCD number (00-99).\n"+
            "The result as to be stored in\n"+
            "internal memory location 40h.\n\n"+

            "ORG 0000H\n"+
            "MOV R0,#20H		; get the source memory address in R0\n"+
            "MOV R1,#40H		; get the destination memory address in R1\n"+
            "MOV A,@R0			; get the ASCII input data to accumulator\n"+
            "ANL A,#0FH		; mask off the upper nibble (convert to unpacked BCD)\n"+
            "SWAP A				; exchange upper and lower nibble\n"+
            "MOV R2,A			; save the accumulator content in R2 register\n"+
            "INC R0				; get the second input memory location\n"+
            "MOV A,@R0			; get the second data to accumulator\n"+
            "ANL A,#0FH		; mask off the upper nibble (convert to unpacked BCD)\n"+
            "ORL A, R2			; convert the two unpacked BCD data to packed data\n"+
            "MOV @R1,A			; store in result memory location\n"+
            "SJMP $\n"+
            "END\n";



    static String program25 = "Program no: 25\n"+
            "Aim	      : Program to convert hexadecimal\n"+
            "number to decimal number.\n"+
            "Program   :To convert the hexadecimal number\n"+
            "placed in the external memory location 8100h to decimal number \n"+
            "and store the result in the external\n"+
            "memory location 8200h and 8201h.\n\n"+

            "ORG 0000H\n"+
            "MOV DPTR,#8100H		; get the input data (hex number ) memory location\n"+
            "MOVX A,@DPTR			; get the input data to accumulator\n"+
            "MOV B,#0AH				; get the divisor to B register\n"+
            "DIV AB					    ; divide input data by 10d\n"+
            "MOV R1,B				    ; store the remainder in register in R1\n"+
            "MOV B,#0AH				; get the divisor to B register\n"+
            "DIV AB					    ; divide the quotient of previous division by 10d\n"+
            "MOV R0,A				    ; move the quotient to R0 register\n"+
            "MOV A,B				        ; get the remainder to accumulator\n"+
            "SWAP A					    ; interchange upper and lower nibble\n"+
            "ORL A,R1				        ; concatenate units and tens place\n"+
            "MOV DPTR,#8201H		; get the result+1 memory location\n"+
            "MOVX @DPTR,A			; store the tens and units(accumulator) place result\n"+
            "DEC DPL				        ; get the result+0 memory address\n"+
            "MOV A,R0				    ; get the hundreds place value of the output to accumulator\n"+
            "MOVX @DPTR,A			; store the result. \n"+
            "SJMP $\n"+
            "END\n";



    static String program26 = "Program no: 26\n"+
            "Aim	      : Program to convert decimal\n"+
            "number to hexadecimal number.\n"+
            "Program      :To convert the decimal number\n"+
            "placed in the external memory location 8100h to hexadecimal \n"+
            "number and store the result in the external\n"+
            "memory location 8101h. \n\n"+

            "ORG 0000H\n"+
            "MOV DPTR,#8100H		; get the input data (decimal number) memory location\n"+
            "MOVX A,@DPTR			; get the input data (decimal number) to accumulator\n"+
            "MOV B,A				        ; get the data to register B\n"+
            "ANL A,#0FH				; mask off the upper nibble of the input data\n"+
            "MOV R1,A				    ; save the accumulator data in register R1\n"+
            "MOV A,B				        ; get the input data to accumulator\n"+
            "ANL A,#0F0H			    ; mask off the lower nibble\n"+
            "SWAP A					    ; interchange the upper and lower nibble\n"+
            "MOV B,#0AH				; get the multiplier to register B\n"+
            "MUL AB					    ; multiply upper nibble of input data with 0Ah\n"+
            "ADD A,R1				        ; add multiplied data with input data\'s lower nibble value\n"+
            "INC DPTR				    ; get the result memory location address to DPTR\n"+
            "MOVX @DPTR,A			; store the hex decimal value in the result memory location\n"+
            "SJMP $\n"+
            "END\n";


    static String program27 = "Program no: 27\n"+
            "Aim	      : Program to display hexadecimal up/down count.\n"+
            "Program      :To display hexadecimal up/down count\n"+
            "(00h to FFh and FFh to 00h) continuously in Port1. \n"+
            "The delay between two counts should be 1 second.\n"+
            "Configure TMOD register in Timer0 Mode1 configuration.\n\n"+

            "ORG 0000H\n"+
            "MOV A,#00H						; get the first BCD value to accumulator\n"+
            "L1:	 MOV P1,A				; display the count in P1\n"+
            "INC A							        ; increment the count\n"+
            "LCALL DELAY					    ; call the delay of 1sec\n"+
            "CJNE A,#0FFH,L1				; check count has reached FFh, if not continue up count\n"+
            "L2:	 MOV P1,A						; display the count in P1\n"+
            "LCALL DELAY					    ; call the delay of 1sec\n"+
            "DEC A							        ; decrement the count\n"+
            "CJNE A,#00H,L2					; check count has reached 00h, if not continue down count\n"+
            "SJMP L1						        ; repeat forever\n"+
            "DELAY:  MOV TMOD,#01H	    ; configure timer0 in mode1\n"+
            "MOV R0,#1FH					    ; get the count for repetition of timer register count\n"+
            "BACK:   MOV TL0,#00H	    ; set the initial count for 1sec\n"+
            "MOV TH0,#00H\n"+
            "SETB TR0						    ; start the timer\n"+
            "REPEAT: JNB TF0, REPEAT				; wait until timer overflows\n"+
            "CLR TR0						                    ; halt the timer\n"+
            "CLR TF0						                    ; clear the timer0 overflow interrupt\n"+
            "DJNZ R0,BACK					            ; if repetition count!= 0, go to label back\n"+
            "RET					    ; return to the main program\n"+
            "END\n";




    static String program28 = "Program no: 28\n"+
            "Aim	   : Program to display BCD up count.\n"+
            "Program   :To display BCD up count (00 to 99)\n"+
            "continuously in Port1. The delay between\n"+
            "two counts should be 1 second.\n"+
            "Configure TMOD register in Timer0 Mode1 configuration.\n\n"+

            "ORG 0000H\n"+
            "MOV A,#00H						; get the first BCD value to accumulator\n"+
            "L1:	MOV P1,A						; display the count in P1\n"+
            "ADD A,#01H						; get the next count to be displayed\n"+
            "DA A							        ; decimal adjust the count\n"+
            "LCALL DELAY					    ; call the delay of 1sec\n"+
            "SJMP L1						        ; repeat forever\n"+

            "DELAY:  MOV TMOD,#01H					; configure timer0 in mode1\n"+
            "MOV R0,#1FH					                    ; get the count for repetition of timer register count\n"+
            "BACK:   MOV TL0,#00H					    ; set the initial count for 1sec\n"+
            "MOV TH0,#00H\n"+
            "SETB TR0						                    ; start the timer\n"+
            "REPEAT: JNB TF0, REPEAT				    ; wait until timer overflows\n"+
            "CLR TR0						                        ; halt the timer\n"+
            "CLR TF0						                        ; clear the timer0 overflow interrupt\n"+
            "DJNZ R0, BACK					                ; if repetition count!= 0, go to label back\n"+
            "RET							                            ; return to the main program\n"+
            "END\n";


    static String program29 = "Program no: 29\n"+
            "Aim	      : Program to display BCD down count.\n"+
            "Program   :To display BCD down count (99 to 00)\n"+
            "continuously in Port1. The delay between two counts \n"+
            "should be 1 second. Configure TMOD register\n"+
            "in Timer0 Mode1 configuration.\n\n"+

            "ORG 0000H\n"+
            "MOV A, #99H				           ; get the first BCD value to accumulator\n"+
            "L1: 	MOV P1,A					       ; display the count in P1\n"+
            "ADD A, #99H				           ; get the next BCD down count value\n"+
            "DA A						               ; decimal adjust the count\n"+
            "LCALL DELAY				           ; call the delay of 1sec\n"+
            "SJMP L1					               ; repeat forever\n"+

            "DELAY:	MOV TMOD,#01H				; configure timer0 in mode1\n"+
            "MOV R0,#1FH				                    ; get the count for repetition of timer register count\n"+
            "BACK:	MOV TL0,#00H				    ; set the initial count for 1sec\n"+
            "MOV TH0,#00H\n"+
            "SETB TR0					                    ; start the timer\n"+
            "REPEAT: JNB TF0, REPEAT			    ; wait until timer overflows\n"+
            "CLR TR0					                        ; halt the timer\n"+
            "CLR TF0					                        ; clear the timer0 overflow interrupt\n"+
            "DJNZ R0, BACK				                ; if repetition count!= 0, go to label back\n"+
            "RET						                            ; return to the main program\n"+
            "END\n";




    static String program30 = "Program no: 30\n"+
            "Aim	      : Program to find the GCD and\n"+
            "LCM of the given two numbers.\n"+
            "Program	  :To find  the GCD and LCM of the\n"+
            "given two numbers, which are placed in the external memory \n"+
            "location 9400h and 9401h. The GCD of the two\n"+
            "given numbers as to be stored in external memory location \n"+
            "9402h and the LCM as to be stored in the\n\n"+
            "external memory location 9403h and 9404h.\n\n"+

            "ORG 0000H\n"+
            "MOV DPTR,#9400H				; get the source memory address	\n"+
            "MOVX A,@DPTR					; get the first value to Accumulator\n"+
            "MOV R1,A						    ; store the first input value in R1 register\n"+
            "MOV R3,A						    ; store the first input value in R3 register\n"+
            "INC DPTR						    ; get the source memory+1 address\n"+
            "MOVX A,@DPTR					; get the second value to accumulator\n"+
            "MOV R2,A						    ; store the second input value to register R2\n"+
            "MOV R4,A						    ; store the second input value to register R4\n"+
            "AGAIN:	MOV A,R1				; get the first input value back to accumulator\n"+
            "CJNE A, 02H,CHECK			; if input1! = input2 jump to label \'CHECK\'\n"+
            "SJMP OVER						    ; if two inputs are equal jump to label \'OVER\'\n"+
            "CHECK:  JNC GCD				; if input1 > input2, jump to label \'GCD\'\n"+
            "XCH A,R2						    ; if input2 > input1, exchange both the inputs\n"+
            "MOV R1,A\n"+
            "GCD:	CLR C						; clear carry flag\n"+
            "SUBB A,R2						    ; subtract first number from second number\n"+
            "MOV R1,A						    ; get the result of subtraction to register R1\n"+
            "SJMP AGAIN					    ; go back to label \'AGAIN\'\n"+
            "OVER:	INC DPTR					; get the result memory address\n"+
            "MOVX @DPTR,A					; store	 the GCD of two input numbers in result memory.\n"+
            "MOV B,A						        ; get the GCD output to B register\n"+
            "MOV A,R3						    ; get the first input to Accumulator\n"+
            "DIV AB							    ; divide second input number by GCD value\n"+
            "MOV B,R4						    ; get the second number to register B\n"+
            "MUL AB							    ; multiply second number with previous division\'s quotient\n"+
            "INC DPTR\n"+
            "INC DPTR						    ;get the result+2 memory address\n"+
            "MOVX @DPTR,A				    ; store the lower byte of LCM output to result+2 memory\n"+
            "MOV A,B						        ; get the upper byte of LCM value to register A\n"+
            "DEC DPL						        ; get the result+1 memory address\n"+
            "MOVX @DPTR,A					; store the upper byte of LCM output to result+1 memory\n"+
            "SJMP $\n"+
            "END\n";




    static String program31 = "Program no: 31 \n"+
            "Aim	   : Program to find the factorial of\n"+
            "the given number (up to 6!).\n"+
            "Program   :To find the factorial of the given\n"+
            "number placed in the external memory location 8300h. \n"+
            "The result as to be stored in the\n"+
            "memory location 8400h and 8401h.\n\n"+

            "ORG 0000H\n"+
            "MOV DPTR, #8300H				     ; get the input memory address\n"+
            "MOVX A, @DPTR					         ; get the input number to accumulator\n"+
            "MOV B, #00H					             ; clear register B\n"+
            "CJNE A, #00H, NEXT				     ; if input number is! = 00 jump to label \'NEXT\'\n"+
            "MOV A, #01H					             ; if input number is = 00 store factorial as 01 in accumulator\n"+
            "SJMP L2						                 ; jump to label \'L2\'\n"+
            "NEXT:	CJNE A, #01H, FACTO		 ; if input number is! = 01 jump to label \'FACTO\'\n"+
            "SJMP L2						                 ; jump to label \'L2\'\n"+
            "FACTO:  MOV R1, #01H				 ; Initialize register R1 with 01\n"+
            "MOV R2, #01H					         ; Initialize register R2 with 01\n"+
            "MOV R0, A						             ; copy the input data to register R0\n"+
            "REPEAT: MOV A, R2						 ; get the R2 register content to accumulator\n"+
            "INC R1							                 ; increment the register R1 content\n"+
            "MOV B, R1						             ; get the R1 register content to register B\n"+
            "MUL AB							             ; multiply the accumulator and B register content\n"+
            "MOV R2, A						             ; store the lower byte of result to register R2\n"+
            "MOV A, R0						             ; get the input number to accumulator\n"+
            "CJNE A, 01H, REPEAT			         ; if input number! = register R1 content, jump to \'REPEAT\'\n"+
            "MOV A, R2						             ; if equal, get lower byte of factorial output to accumulator\n"+
            "L2:	 MOV DPTR, #8401H 			 ; get the result+1 memory address\n"+
            "MOVX @DPTR, A					         ; store the lower byte of result in result+1 memory\n"+
            "DEC DPL						                 ; get the result memory address\n"+
            "MOV A, B						                 ; get the upper byte of factorial result to accumulator\n"+
            "MOVX @DPTR, A					         ; store the upper byte of result in result memory\n"+
            "SJMP $\n"+
            "END\n";



    static String program32 = "Program no: 32\n"+
            "Aim	      : Program to generate square wave of\n"+
            "50% duty cycle with the time delay of 10ms. \n"+
            "Program	  :To generate the square wave in P1\n"+
            "with the 50% duty cycle and the time delay of 10ms using timer.\n"+
            "Assume the crystal frequency of\n"+
            "24 MHz Configure the timer in Timer0 mode1.\n\n"+

            "ORG 0000H\n"+
            "MOV P1, #0FFH		                        	; initialize P1\n"+
            "BACK:		XRL 90H, #0FFH   		        ; generate square wave signal\n"+
            "ACALL DELAY			                            ; call 10ms delay\n"+
            "SJMP BACK				                            ; repeat forever\n"+

            "DELAY: MOV TMOD, #01H			        ; configure the timer0 in mode1\n"+
            "MOV TL0, #0E0H			                    ; set the initial value in timer register for 10ms\n"+
            "MOV TH0, #0B1H\n"+
            "SETB TR0				                            ; start the timer\n"+

            "REPEAT:	JNB TF0, REPEAT			        ; wait until timer overflows\n"+
            "CLR TR0				                                ; halt the timer\n"+
            "CLR TF0				                                ; clear the timer0 overflow interrupt\n"+
            "RET					                                    ; return to the main program\n"+
            "END\n";



    static String program33 = "Program no: 33\n"+
            "Aim	      : Program to generate square wave\n"+
            "with the on time delay of 6ms and off time delay of 4msec. \n"+
            "Program	  :To generate the square wave with\n"+
            "the on time delay of 6ms and off time delay of 4msec.\n"+
            "Configure the timer in Timer0 mode1.\n"+
            "Assume the crystal frequency of 24 MHz.\n\n"+

            "ORG 0000H\n"+
            "BACK:		 MOV P1, #00H			           ; generate OFF time through P1\n"+
            "ACALL DELAY			                           ; Call 2ms delay subroutine twice to get 4ms\n"+
            "ACALL DELAY\n"+
            "MOV P1, #0FFH			                      ; generate ON time through P1\n"+
            "ACALL DELAY			                          ; Call 2ms delay subroutine thrice to get 6ms\n"+
            "ACALL DELAY\n"+
            "ACALL DELAY\n"+
            "SJMP BACK				                          ; repeat the processes forever\n"+

            "DELAY:		MOV TMOD, #01H		  ; configure the timer0 in mode1\n"+
            "MOV TL0, #060H			                  ; set the initial value in timer register for 2ms\n"+
            "MOV TH0, #0F0H\n"+
            "SETB TR0				                          ; start the timer\n"+

            "REPEAT:	JNB TF0, REPEAT		          ; wait until timer overflows\n"+
            "CLR TR0				                              ; halt the timer\n"+
            "CLR TF0				                              ; clear the timer0 overflow interrupt\n"+
            "RET					                                  ; ret to the main program\n"+
            "END\n";



    static String program34 = "Program no: 34\n"+
            "Aim	      : Program to send the letter \'J\'\n"+
            "serially using UART at the baud rate of 9600. \n"+
            "Program	  :To send the letter \'J\'\n"+
            "serially using the UART at the baud rate of 9600. \n"+
            "Configure SCON register in mode 1.\n"+
            "Assume the crystal frequency of 11.0592 MHz\n\n"+

            "ORG 0000H\n"+
            "BACK:	MOV TMOD, #20H				         ; configure the timer1 in mode 2\n"+
            "MOV TH1, #-3				                             ; count for the baud rate of 9600\n"+
            "MOV SCON, #50H				                     ; configure SCON to mode1\n"+
            "SETB TR1					                             ; start the timer	\n"+
            "MOV SBUF, #'J'				                         ; send the letter \'J\' through SBUF register\n"+
            "HERE:   JNB TI, HERE				                 ; wait until \'J\' character is sent (8bits are transferred) \n"+
            "CLR TI						                                 ; clear serial interrupt for next character to be sent\n"+
            "SJMP BACK					                             ; repeat the processes\n"+
            "SJMP $\n"+
            "END\n";




    static String program35 = "Program no: 35\n"+
            "Aim	      : Program to realize the given Boolean expression.\n"+
            "Program	  :To realize the Boolean expression \n"+
            "BD+A +AB . And A=1, B=1, D=0. \n"+
            "Store the input in the 00h, 01h and 02h\n"+
            "bit memory location. Store the result of  \n"+
            "BD in 03h bit memory location and store\n"+
            "the result of A  in 04h bit memory location. \n"+
            "Store the final result in 08h bit memory location.\n\n"+

            "ORG 0000H\n"+
            "SETB 00H				; initialize input A=1\n"+
            "SETB 01H				; initialize input B=1\n"+
            "CLR 02H				    ;initialize input D01\n"+
            "MOV C,01H				; get B input to carry flag\n"+
            "ANL C,02H				; AND Dwith B\n"+
            "ANL C,/00H				; get the expression  BD\n"+
            "MOV 03H,C				; store it in 03h bit memory location\n"+
            "MOV C,00H				; get A input to carry flag\n"+
            "ANL C,02H				; AND D with A\n"+
            "ANL C,/01H				; get the expression A \n"+
            "MOV 04H,C				; store it in 04h bit memory location\n"+
            "MOV C,00H				; get A input to carry flag\n"+
            "ANL C,01H				; AND B with A\n"+
            "ANL C,/02H				; get the expression AB \n"+
            "ORL C,03H				;AB  +  BD\n"+
            "ORL C, 04H				;AB  +  BD + A \n"+
            "MOV 08H,C				; store the result in the internal bit memory 08h\n"+
            "SJMP $\n"+
            "END\n";

    public ExperimentsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_experiments, container, false);

        for(int i = 0; i< 35; i++)
        {
            b[i] = (Button) view.findViewById(buttonId[i]);
            b[i].setOnClickListener(this);
        }
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onClick(View v) {
        int btnid = v.getId();
        Intent i;
        //Toast.makeText(this.getActivity(),"Button is clicked!", Toast.LENGTH_LONG).show();
        switch (btnid)
        {
            case R.id.button1:
                i = new Intent(this.getActivity(),Programs.class); i.putExtra("c1", program1);
                startActivity(i);
                break;
            case R.id.button2:
                i = new Intent(this.getActivity(),Programs.class); i.putExtra("c2", program2);
                startActivity(i);
                break;
            case R.id.button3:
                i = new Intent(this.getActivity(),Programs.class); i.putExtra("c3", program3);
                startActivity(i);
                break;
            case R.id.button4:
                i = new Intent(this.getActivity(),Programs.class); i.putExtra("c4", program4);
                startActivity(i);
                break;
            case R.id.button5:
                i = new Intent(this.getActivity(),Programs.class); i.putExtra("c5", program5);
                startActivity(i);
                break;
            case R.id.button6:
                i = new Intent(this.getActivity(),Programs.class); i.putExtra("c6", program6);
                startActivity(i);
                break;
            case R.id.button7:
                i = new Intent(this.getActivity(),Programs.class); i.putExtra("c7", program7);
                startActivity(i);
                break;
            case R.id.button8:
                i = new Intent(this.getActivity(),Programs.class); i.putExtra("c8", program8);
                startActivity(i);
                break;
            case R.id.button9:
                i = new Intent(this.getActivity(),Programs.class); i.putExtra("c9", program9);
                startActivity(i);
                break;
            case R.id.button10:
                i = new Intent(this.getActivity(),Programs.class); i.putExtra("c10", program10);
                startActivity(i);
                break;
            case R.id.button11:
                i = new Intent(this.getActivity(),Programs.class); i.putExtra("c11", program11);
                startActivity(i);
                break;
            case R.id.button12:
                i = new Intent(this.getActivity(),Programs.class); i.putExtra("c12", program12);
                startActivity(i);
                break;
            case R.id.button13:
                i = new Intent(this.getActivity(),Programs.class); i.putExtra("c13", program13);
                startActivity(i);
                break;
            case R.id.button14:
                i = new Intent(this.getActivity(),Programs.class); i.putExtra("c14", program14);
                startActivity(i);
                break;
            case R.id.button15:
                i = new Intent(this.getActivity(),Programs.class); i.putExtra("c15", program15);
                startActivity(i);
                break;
            case R.id.button16:
                i = new Intent(this.getActivity(),Programs.class); i.putExtra("c16", program16);
                startActivity(i);
                break;
            case R.id.button17:
                i = new Intent(this.getActivity(),Programs.class); i.putExtra("c17", program17);
                startActivity(i);
                break;
            case R.id.button18:
                i = new Intent(this.getActivity(),Programs.class); i.putExtra("c18", program18);
                startActivity(i);
                break;
            case R.id.button19:
                i = new Intent(this.getActivity(),Programs.class); i.putExtra("c19", program19);
                startActivity(i);
                break;
            case R.id.button20:
                i = new Intent(this.getActivity(),Programs.class); i.putExtra("c20", program20);
                startActivity(i);
                break;
            case R.id.button21:
                i = new Intent(this.getActivity(),Programs.class); i.putExtra("c21", program21);
                startActivity(i);
                break;
            case R.id.button22:
                i = new Intent(this.getActivity(),Programs.class); i.putExtra("c22", program22);
                startActivity(i);
                break;
            case R.id.button23:
                i = new Intent(this.getActivity(),Programs.class); i.putExtra("c23", program23);
                startActivity(i);
                break;
            case R.id.button24:
                i = new Intent(this.getActivity(),Programs.class); i.putExtra("c24", program24);
                startActivity(i);
                break;
            case R.id.button25:
                i = new Intent(this.getActivity(),Programs.class); i.putExtra("c25", program25);
                startActivity(i);
                break;
            case R.id.button26:
                i = new Intent(this.getActivity(),Programs.class); i.putExtra("c26", program26);
                startActivity(i);
                break;
            case R.id.button27:
                i = new Intent(this.getActivity(),Programs.class); i.putExtra("c27", program27);
                startActivity(i);
                break;
            case R.id.button28:
                i = new Intent(this.getActivity(),Programs.class); i.putExtra("c28", program28);
                startActivity(i);
                break;
            case R.id.button29:
                i = new Intent(this.getActivity(),Programs.class); i.putExtra("c29", program29);
                startActivity(i);
                break;
            case R.id.button30:
                i = new Intent(this.getActivity(),Programs.class); i.putExtra("c30", program30);
                startActivity(i);
                break;
            case R.id.button31:
                i = new Intent(this.getActivity(),Programs.class); i.putExtra("c31", program31);
                startActivity(i);
                break;
            case R.id.button32:
                i = new Intent(this.getActivity(),Programs.class); i.putExtra("c32", program32);
                startActivity(i);
                break;
            case R.id.button33:
                i = new Intent(this.getActivity(),Programs.class); i.putExtra("c33", program33);
                startActivity(i);
                break;
            case R.id.button34:
                i = new Intent(this.getActivity(),Programs.class); i.putExtra("c34", program34);
                startActivity(i);
                break;
            case R.id.button35:
                i = new Intent(this.getActivity(),Programs.class); i.putExtra("c35", program35);
                startActivity(i);
                break;
        }

    }
}
