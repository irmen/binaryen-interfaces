package razorvine.kbinaryen

import com.sun.jna.Library
import com.sun.jna.Native
import com.sun.jna.Platform
import com.sun.jna.Pointer
import com.sun.jna.Structure

typealias BinaryenIndex = Int
typealias BinaryenType = Int
typealias BinaryenExpressionId = Int
typealias BinaryenExternalKind = Int
typealias BinaryenFeatures = Int
typealias BinaryenModuleRef = Pointer
typealias BinaryenFunctionTypeRef = Pointer
class BinaryenLiteral: Structure()
typealias BinaryenOp = Int
typealias BinaryenExpressionRef = Pointer
typealias BinaryenFunctionRef = Pointer
typealias BinaryenExportRef = Pointer
typealias BinaryenGlobalRef = Pointer
typealias BinaryenEventRef = Pointer
class BinaryenBufferSizes: Structure()
class BinaryenModuleAllocateAndWriteResult: Structure()
typealias RelooperRef = Pointer
typealias RelooperBlockRef = Pointer


interface Binaryen: Library {

    companion object {
        init {
            if(!Platform.isWindows())
                System.setProperty("jna.library.path", "/usr/local/lib")
        }

        val INSTANCE: Binaryen by lazy { Native.load("binaryen", Binaryen::class.java) }

//        init {
//            val library = NativeLibrary.getInstance("/usr/local/lib/libbinaryen.so")
//            Native.register(Binaryen::class.java, library)
//        }
    }

    fun BinaryenTypeNone(): BinaryenType
    fun BinaryenTypeInt32(): BinaryenType
    fun BinaryenTypeInt64(): BinaryenType
    fun BinaryenTypeFloat32(): BinaryenType
    fun BinaryenTypeFloat64(): BinaryenType
    fun BinaryenTypeVec128(): BinaryenType
    fun BinaryenTypeAnyref(): BinaryenType
    fun BinaryenTypeExnref(): BinaryenType
    fun BinaryenTypeUnreachable(): BinaryenType
    fun BinaryenTypeAuto(): BinaryenType
    fun BinaryenInvalidId(): BinaryenExpressionId
    fun BinaryenBlockId(): BinaryenExpressionId
    fun BinaryenIfId(): BinaryenExpressionId
    fun BinaryenLoopId(): BinaryenExpressionId
    fun BinaryenBreakId(): BinaryenExpressionId
    fun BinaryenSwitchId(): BinaryenExpressionId
    fun BinaryenCallId(): BinaryenExpressionId
    fun BinaryenCallIndirectId(): BinaryenExpressionId
    fun BinaryenLocalGetId(): BinaryenExpressionId
    fun BinaryenLocalSetId(): BinaryenExpressionId
    fun BinaryenGlobalGetId(): BinaryenExpressionId
    fun BinaryenGlobalSetId(): BinaryenExpressionId
    fun BinaryenLoadId(): BinaryenExpressionId
    fun BinaryenStoreId(): BinaryenExpressionId
    fun BinaryenConstId(): BinaryenExpressionId
    fun BinaryenUnaryId(): BinaryenExpressionId
    fun BinaryenBinaryId(): BinaryenExpressionId
    fun BinaryenSelectId(): BinaryenExpressionId
    fun BinaryenDropId(): BinaryenExpressionId
    fun BinaryenReturnId(): BinaryenExpressionId
    fun BinaryenHostId(): BinaryenExpressionId
    fun BinaryenNopId(): BinaryenExpressionId
    fun BinaryenUnreachableId(): BinaryenExpressionId
    fun BinaryenAtomicCmpxchgId(): BinaryenExpressionId
    fun BinaryenAtomicRMWId(): BinaryenExpressionId
    fun BinaryenAtomicWaitId(): BinaryenExpressionId
    fun BinaryenAtomicNotifyId(): BinaryenExpressionId
    fun BinaryenAtomicFenceId(): BinaryenExpressionId
    fun BinaryenSIMDExtractId(): BinaryenExpressionId
    fun BinaryenSIMDReplaceId(): BinaryenExpressionId
    fun BinaryenSIMDShuffleId(): BinaryenExpressionId
    fun BinaryenSIMDTernaryId(): BinaryenExpressionId
    fun BinaryenSIMDShiftId(): BinaryenExpressionId
    fun BinaryenSIMDLoadId(): BinaryenExpressionId
    fun BinaryenMemoryInitId(): BinaryenExpressionId
    fun BinaryenDataDropId(): BinaryenExpressionId
    fun BinaryenMemoryCopyId(): BinaryenExpressionId
    fun BinaryenMemoryFillId(): BinaryenExpressionId
    fun BinaryenTryId(): BinaryenExpressionId
    fun BinaryenThrowId(): BinaryenExpressionId
    fun BinaryenRethrowId(): BinaryenExpressionId
    fun BinaryenBrOnExnId(): BinaryenExpressionId
    fun BinaryenPushId(): BinaryenExpressionId
    fun BinaryenPopId(): BinaryenExpressionId
    fun BinaryenExternalFunction(): BinaryenExternalKind
    fun BinaryenExternalTable(): BinaryenExternalKind
    fun BinaryenExternalMemory(): BinaryenExternalKind
    fun BinaryenExternalGlobal(): BinaryenExternalKind
    fun BinaryenExternalEvent(): BinaryenExternalKind
    fun BinaryenFeatureMVP(): BinaryenFeatures
    fun BinaryenFeatureAtomics(): BinaryenFeatures
    fun BinaryenFeatureBulkMemory(): BinaryenFeatures
    fun BinaryenFeatureMutableGlobals(): BinaryenFeatures
    fun BinaryenFeatureNontrappingFPToInt(): BinaryenFeatures
    fun BinaryenFeatureSignExt(): BinaryenFeatures
    fun BinaryenFeatureSIMD128(): BinaryenFeatures
    fun BinaryenFeatureExceptionHandling(): BinaryenFeatures
    fun BinaryenFeatureTailCall(): BinaryenFeatures
    fun BinaryenFeatureReferenceTypes(): BinaryenFeatures
    fun BinaryenFeatureAll(): BinaryenFeatures
    fun BinaryenModuleCreate(): BinaryenModuleRef
    fun BinaryenModuleDispose(module: BinaryenModuleRef)
    fun BinaryenAddFunctionType(module: BinaryenModuleRef, name: String?, result: BinaryenType, paramTypes: IntArray?, numParams: BinaryenIndex): BinaryenFunctionTypeRef
    fun BinaryenRemoveFunctionType(module: BinaryenModuleRef, name: String?)
    fun BinaryenLiteralInt32(x: Int): BinaryenLiteral
    fun BinaryenLiteralInt64(x: Long): BinaryenLiteral
    fun BinaryenLiteralFloat32(x: Float): BinaryenLiteral
    fun BinaryenLiteralFloat64(x: Double): BinaryenLiteral
    fun BinaryenLiteralVec128(x: ByteArray?): BinaryenLiteral
    fun BinaryenLiteralFloat32Bits(x: Int): BinaryenLiteral
    fun BinaryenLiteralFloat64Bits(x: Long): BinaryenLiteral
    fun BinaryenClzInt32(): BinaryenOp
    fun BinaryenCtzInt32(): BinaryenOp
    fun BinaryenPopcntInt32(): BinaryenOp
    fun BinaryenNegFloat32(): BinaryenOp
    fun BinaryenAbsFloat32(): BinaryenOp
    fun BinaryenCeilFloat32(): BinaryenOp
    fun BinaryenFloorFloat32(): BinaryenOp
    fun BinaryenTruncFloat32(): BinaryenOp
    fun BinaryenNearestFloat32(): BinaryenOp
    fun BinaryenSqrtFloat32(): BinaryenOp
    fun BinaryenEqZInt32(): BinaryenOp
    fun BinaryenClzInt64(): BinaryenOp
    fun BinaryenCtzInt64(): BinaryenOp
    fun BinaryenPopcntInt64(): BinaryenOp
    fun BinaryenNegFloat64(): BinaryenOp
    fun BinaryenAbsFloat64(): BinaryenOp
    fun BinaryenCeilFloat64(): BinaryenOp
    fun BinaryenFloorFloat64(): BinaryenOp
    fun BinaryenTruncFloat64(): BinaryenOp
    fun BinaryenNearestFloat64(): BinaryenOp
    fun BinaryenSqrtFloat64(): BinaryenOp
    fun BinaryenEqZInt64(): BinaryenOp
    fun BinaryenExtendSInt32(): BinaryenOp
    fun BinaryenExtendUInt32(): BinaryenOp
    fun BinaryenWrapInt64(): BinaryenOp
    fun BinaryenTruncSFloat32ToInt32(): BinaryenOp
    fun BinaryenTruncSFloat32ToInt64(): BinaryenOp
    fun BinaryenTruncUFloat32ToInt32(): BinaryenOp
    fun BinaryenTruncUFloat32ToInt64(): BinaryenOp
    fun BinaryenTruncSFloat64ToInt32(): BinaryenOp
    fun BinaryenTruncSFloat64ToInt64(): BinaryenOp
    fun BinaryenTruncUFloat64ToInt32(): BinaryenOp
    fun BinaryenTruncUFloat64ToInt64(): BinaryenOp
    fun BinaryenReinterpretFloat32(): BinaryenOp
    fun BinaryenReinterpretFloat64(): BinaryenOp
    fun BinaryenConvertSInt32ToFloat32(): BinaryenOp
    fun BinaryenConvertSInt32ToFloat64(): BinaryenOp
    fun BinaryenConvertUInt32ToFloat32(): BinaryenOp
    fun BinaryenConvertUInt32ToFloat64(): BinaryenOp
    fun BinaryenConvertSInt64ToFloat32(): BinaryenOp
    fun BinaryenConvertSInt64ToFloat64(): BinaryenOp
    fun BinaryenConvertUInt64ToFloat32(): BinaryenOp
    fun BinaryenConvertUInt64ToFloat64(): BinaryenOp
    fun BinaryenPromoteFloat32(): BinaryenOp
    fun BinaryenDemoteFloat64(): BinaryenOp
    fun BinaryenReinterpretInt32(): BinaryenOp
    fun BinaryenReinterpretInt64(): BinaryenOp
    fun BinaryenExtendS8Int32(): BinaryenOp
    fun BinaryenExtendS16Int32(): BinaryenOp
    fun BinaryenExtendS8Int64(): BinaryenOp
    fun BinaryenExtendS16Int64(): BinaryenOp
    fun BinaryenExtendS32Int64(): BinaryenOp
    fun BinaryenAddInt32(): BinaryenOp
    fun BinaryenSubInt32(): BinaryenOp
    fun BinaryenMulInt32(): BinaryenOp
    fun BinaryenDivSInt32(): BinaryenOp
    fun BinaryenDivUInt32(): BinaryenOp
    fun BinaryenRemSInt32(): BinaryenOp
    fun BinaryenRemUInt32(): BinaryenOp
    fun BinaryenAndInt32(): BinaryenOp
    fun BinaryenOrInt32(): BinaryenOp
    fun BinaryenXorInt32(): BinaryenOp
    fun BinaryenShlInt32(): BinaryenOp
    fun BinaryenShrUInt32(): BinaryenOp
    fun BinaryenShrSInt32(): BinaryenOp
    fun BinaryenRotLInt32(): BinaryenOp
    fun BinaryenRotRInt32(): BinaryenOp
    fun BinaryenEqInt32(): BinaryenOp
    fun BinaryenNeInt32(): BinaryenOp
    fun BinaryenLtSInt32(): BinaryenOp
    fun BinaryenLtUInt32(): BinaryenOp
    fun BinaryenLeSInt32(): BinaryenOp
    fun BinaryenLeUInt32(): BinaryenOp
    fun BinaryenGtSInt32(): BinaryenOp
    fun BinaryenGtUInt32(): BinaryenOp
    fun BinaryenGeSInt32(): BinaryenOp
    fun BinaryenGeUInt32(): BinaryenOp
    fun BinaryenAddInt64(): BinaryenOp
    fun BinaryenSubInt64(): BinaryenOp
    fun BinaryenMulInt64(): BinaryenOp
    fun BinaryenDivSInt64(): BinaryenOp
    fun BinaryenDivUInt64(): BinaryenOp
    fun BinaryenRemSInt64(): BinaryenOp
    fun BinaryenRemUInt64(): BinaryenOp
    fun BinaryenAndInt64(): BinaryenOp
    fun BinaryenOrInt64(): BinaryenOp
    fun BinaryenXorInt64(): BinaryenOp
    fun BinaryenShlInt64(): BinaryenOp
    fun BinaryenShrUInt64(): BinaryenOp
    fun BinaryenShrSInt64(): BinaryenOp
    fun BinaryenRotLInt64(): BinaryenOp
    fun BinaryenRotRInt64(): BinaryenOp
    fun BinaryenEqInt64(): BinaryenOp
    fun BinaryenNeInt64(): BinaryenOp
    fun BinaryenLtSInt64(): BinaryenOp
    fun BinaryenLtUInt64(): BinaryenOp
    fun BinaryenLeSInt64(): BinaryenOp
    fun BinaryenLeUInt64(): BinaryenOp
    fun BinaryenGtSInt64(): BinaryenOp
    fun BinaryenGtUInt64(): BinaryenOp
    fun BinaryenGeSInt64(): BinaryenOp
    fun BinaryenGeUInt64(): BinaryenOp
    fun BinaryenAddFloat32(): BinaryenOp
    fun BinaryenSubFloat32(): BinaryenOp
    fun BinaryenMulFloat32(): BinaryenOp
    fun BinaryenDivFloat32(): BinaryenOp
    fun BinaryenCopySignFloat32(): BinaryenOp
    fun BinaryenMinFloat32(): BinaryenOp
    fun BinaryenMaxFloat32(): BinaryenOp
    fun BinaryenEqFloat32(): BinaryenOp
    fun BinaryenNeFloat32(): BinaryenOp
    fun BinaryenLtFloat32(): BinaryenOp
    fun BinaryenLeFloat32(): BinaryenOp
    fun BinaryenGtFloat32(): BinaryenOp
    fun BinaryenGeFloat32(): BinaryenOp
    fun BinaryenAddFloat64(): BinaryenOp
    fun BinaryenSubFloat64(): BinaryenOp
    fun BinaryenMulFloat64(): BinaryenOp
    fun BinaryenDivFloat64(): BinaryenOp
    fun BinaryenCopySignFloat64(): BinaryenOp
    fun BinaryenMinFloat64(): BinaryenOp
    fun BinaryenMaxFloat64(): BinaryenOp
    fun BinaryenEqFloat64(): BinaryenOp
    fun BinaryenNeFloat64(): BinaryenOp
    fun BinaryenLtFloat64(): BinaryenOp
    fun BinaryenLeFloat64(): BinaryenOp
    fun BinaryenGtFloat64(): BinaryenOp
    fun BinaryenGeFloat64(): BinaryenOp
    fun BinaryenMemorySize(): BinaryenOp
    fun BinaryenMemoryGrow(): BinaryenOp
    fun BinaryenAtomicRMWAdd(): BinaryenOp
    fun BinaryenAtomicRMWSub(): BinaryenOp
    fun BinaryenAtomicRMWAnd(): BinaryenOp
    fun BinaryenAtomicRMWOr(): BinaryenOp
    fun BinaryenAtomicRMWXor(): BinaryenOp
    fun BinaryenAtomicRMWXchg(): BinaryenOp
    fun BinaryenTruncSatSFloat32ToInt32(): BinaryenOp
    fun BinaryenTruncSatSFloat32ToInt64(): BinaryenOp
    fun BinaryenTruncSatUFloat32ToInt32(): BinaryenOp
    fun BinaryenTruncSatUFloat32ToInt64(): BinaryenOp
    fun BinaryenTruncSatSFloat64ToInt32(): BinaryenOp
    fun BinaryenTruncSatSFloat64ToInt64(): BinaryenOp
    fun BinaryenTruncSatUFloat64ToInt32(): BinaryenOp
    fun BinaryenTruncSatUFloat64ToInt64(): BinaryenOp
    fun BinaryenSplatVecI8x16(): BinaryenOp
    fun BinaryenExtractLaneSVecI8x16(): BinaryenOp
    fun BinaryenExtractLaneUVecI8x16(): BinaryenOp
    fun BinaryenReplaceLaneVecI8x16(): BinaryenOp
    fun BinaryenSplatVecI16x8(): BinaryenOp
    fun BinaryenExtractLaneSVecI16x8(): BinaryenOp
    fun BinaryenExtractLaneUVecI16x8(): BinaryenOp
    fun BinaryenReplaceLaneVecI16x8(): BinaryenOp
    fun BinaryenSplatVecI32x4(): BinaryenOp
    fun BinaryenExtractLaneVecI32x4(): BinaryenOp
    fun BinaryenReplaceLaneVecI32x4(): BinaryenOp
    fun BinaryenSplatVecI64x2(): BinaryenOp
    fun BinaryenExtractLaneVecI64x2(): BinaryenOp
    fun BinaryenReplaceLaneVecI64x2(): BinaryenOp
    fun BinaryenSplatVecF32x4(): BinaryenOp
    fun BinaryenExtractLaneVecF32x4(): BinaryenOp
    fun BinaryenReplaceLaneVecF32x4(): BinaryenOp
    fun BinaryenSplatVecF64x2(): BinaryenOp
    fun BinaryenExtractLaneVecF64x2(): BinaryenOp
    fun BinaryenReplaceLaneVecF64x2(): BinaryenOp
    fun BinaryenEqVecI8x16(): BinaryenOp
    fun BinaryenNeVecI8x16(): BinaryenOp
    fun BinaryenLtSVecI8x16(): BinaryenOp
    fun BinaryenLtUVecI8x16(): BinaryenOp
    fun BinaryenGtSVecI8x16(): BinaryenOp
    fun BinaryenGtUVecI8x16(): BinaryenOp
    fun BinaryenLeSVecI8x16(): BinaryenOp
    fun BinaryenLeUVecI8x16(): BinaryenOp
    fun BinaryenGeSVecI8x16(): BinaryenOp
    fun BinaryenGeUVecI8x16(): BinaryenOp
    fun BinaryenEqVecI16x8(): BinaryenOp
    fun BinaryenNeVecI16x8(): BinaryenOp
    fun BinaryenLtSVecI16x8(): BinaryenOp
    fun BinaryenLtUVecI16x8(): BinaryenOp
    fun BinaryenGtSVecI16x8(): BinaryenOp
    fun BinaryenGtUVecI16x8(): BinaryenOp
    fun BinaryenLeSVecI16x8(): BinaryenOp
    fun BinaryenLeUVecI16x8(): BinaryenOp
    fun BinaryenGeSVecI16x8(): BinaryenOp
    fun BinaryenGeUVecI16x8(): BinaryenOp
    fun BinaryenEqVecI32x4(): BinaryenOp
    fun BinaryenNeVecI32x4(): BinaryenOp
    fun BinaryenLtSVecI32x4(): BinaryenOp
    fun BinaryenLtUVecI32x4(): BinaryenOp
    fun BinaryenGtSVecI32x4(): BinaryenOp
    fun BinaryenGtUVecI32x4(): BinaryenOp
    fun BinaryenLeSVecI32x4(): BinaryenOp
    fun BinaryenLeUVecI32x4(): BinaryenOp
    fun BinaryenGeSVecI32x4(): BinaryenOp
    fun BinaryenGeUVecI32x4(): BinaryenOp
    fun BinaryenEqVecF32x4(): BinaryenOp
    fun BinaryenNeVecF32x4(): BinaryenOp
    fun BinaryenLtVecF32x4(): BinaryenOp
    fun BinaryenGtVecF32x4(): BinaryenOp
    fun BinaryenLeVecF32x4(): BinaryenOp
    fun BinaryenGeVecF32x4(): BinaryenOp
    fun BinaryenEqVecF64x2(): BinaryenOp
    fun BinaryenNeVecF64x2(): BinaryenOp
    fun BinaryenLtVecF64x2(): BinaryenOp
    fun BinaryenGtVecF64x2(): BinaryenOp
    fun BinaryenLeVecF64x2(): BinaryenOp
    fun BinaryenGeVecF64x2(): BinaryenOp
    fun BinaryenNotVec128(): BinaryenOp
    fun BinaryenAndVec128(): BinaryenOp
    fun BinaryenOrVec128(): BinaryenOp
    fun BinaryenXorVec128(): BinaryenOp
    fun BinaryenAndNotVec128(): BinaryenOp
    fun BinaryenBitselectVec128(): BinaryenOp
    fun BinaryenNegVecI8x16(): BinaryenOp
    fun BinaryenAnyTrueVecI8x16(): BinaryenOp
    fun BinaryenAllTrueVecI8x16(): BinaryenOp
    fun BinaryenShlVecI8x16(): BinaryenOp
    fun BinaryenShrSVecI8x16(): BinaryenOp
    fun BinaryenShrUVecI8x16(): BinaryenOp
    fun BinaryenAddVecI8x16(): BinaryenOp
    fun BinaryenAddSatSVecI8x16(): BinaryenOp
    fun BinaryenAddSatUVecI8x16(): BinaryenOp
    fun BinaryenSubVecI8x16(): BinaryenOp
    fun BinaryenSubSatSVecI8x16(): BinaryenOp
    fun BinaryenSubSatUVecI8x16(): BinaryenOp
    fun BinaryenMulVecI8x16(): BinaryenOp
    fun BinaryenNegVecI16x8(): BinaryenOp
    fun BinaryenAnyTrueVecI16x8(): BinaryenOp
    fun BinaryenAllTrueVecI16x8(): BinaryenOp
    fun BinaryenShlVecI16x8(): BinaryenOp
    fun BinaryenShrSVecI16x8(): BinaryenOp
    fun BinaryenShrUVecI16x8(): BinaryenOp
    fun BinaryenAddVecI16x8(): BinaryenOp
    fun BinaryenAddSatSVecI16x8(): BinaryenOp
    fun BinaryenAddSatUVecI16x8(): BinaryenOp
    fun BinaryenSubVecI16x8(): BinaryenOp
    fun BinaryenSubSatSVecI16x8(): BinaryenOp
    fun BinaryenSubSatUVecI16x8(): BinaryenOp
    fun BinaryenMulVecI16x8(): BinaryenOp
    fun BinaryenNegVecI32x4(): BinaryenOp
    fun BinaryenAnyTrueVecI32x4(): BinaryenOp
    fun BinaryenAllTrueVecI32x4(): BinaryenOp
    fun BinaryenShlVecI32x4(): BinaryenOp
    fun BinaryenShrSVecI32x4(): BinaryenOp
    fun BinaryenShrUVecI32x4(): BinaryenOp
    fun BinaryenAddVecI32x4(): BinaryenOp
    fun BinaryenSubVecI32x4(): BinaryenOp
    fun BinaryenMulVecI32x4(): BinaryenOp
    fun BinaryenNegVecI64x2(): BinaryenOp
    fun BinaryenAnyTrueVecI64x2(): BinaryenOp
    fun BinaryenAllTrueVecI64x2(): BinaryenOp
    fun BinaryenShlVecI64x2(): BinaryenOp
    fun BinaryenShrSVecI64x2(): BinaryenOp
    fun BinaryenShrUVecI64x2(): BinaryenOp
    fun BinaryenAddVecI64x2(): BinaryenOp
    fun BinaryenSubVecI64x2(): BinaryenOp
    fun BinaryenAbsVecF32x4(): BinaryenOp
    fun BinaryenNegVecF32x4(): BinaryenOp
    fun BinaryenSqrtVecF32x4(): BinaryenOp
    fun BinaryenQFMAVecF32x4(): BinaryenOp
    fun BinaryenQFMSVecF32x4(): BinaryenOp
    fun BinaryenAddVecF32x4(): BinaryenOp
    fun BinaryenSubVecF32x4(): BinaryenOp
    fun BinaryenMulVecF32x4(): BinaryenOp
    fun BinaryenDivVecF32x4(): BinaryenOp
    fun BinaryenMinVecF32x4(): BinaryenOp
    fun BinaryenMaxVecF32x4(): BinaryenOp
    fun BinaryenAbsVecF64x2(): BinaryenOp
    fun BinaryenNegVecF64x2(): BinaryenOp
    fun BinaryenSqrtVecF64x2(): BinaryenOp
    fun BinaryenQFMAVecF64x2(): BinaryenOp
    fun BinaryenQFMSVecF64x2(): BinaryenOp
    fun BinaryenAddVecF64x2(): BinaryenOp
    fun BinaryenSubVecF64x2(): BinaryenOp
    fun BinaryenMulVecF64x2(): BinaryenOp
    fun BinaryenDivVecF64x2(): BinaryenOp
    fun BinaryenMinVecF64x2(): BinaryenOp
    fun BinaryenMaxVecF64x2(): BinaryenOp
    fun BinaryenTruncSatSVecF32x4ToVecI32x4(): BinaryenOp
    fun BinaryenTruncSatUVecF32x4ToVecI32x4(): BinaryenOp
    fun BinaryenTruncSatSVecF64x2ToVecI64x2(): BinaryenOp
    fun BinaryenTruncSatUVecF64x2ToVecI64x2(): BinaryenOp
    fun BinaryenConvertSVecI32x4ToVecF32x4(): BinaryenOp
    fun BinaryenConvertUVecI32x4ToVecF32x4(): BinaryenOp
    fun BinaryenConvertSVecI64x2ToVecF64x2(): BinaryenOp
    fun BinaryenConvertUVecI64x2ToVecF64x2(): BinaryenOp
    fun BinaryenLoadSplatVec8x16(): BinaryenOp
    fun BinaryenLoadSplatVec16x8(): BinaryenOp
    fun BinaryenLoadSplatVec32x4(): BinaryenOp
    fun BinaryenLoadSplatVec64x2(): BinaryenOp
    fun BinaryenLoadExtSVec8x8ToVecI16x8(): BinaryenOp
    fun BinaryenLoadExtUVec8x8ToVecI16x8(): BinaryenOp
    fun BinaryenLoadExtSVec16x4ToVecI32x4(): BinaryenOp
    fun BinaryenLoadExtUVec16x4ToVecI32x4(): BinaryenOp
    fun BinaryenLoadExtSVec32x2ToVecI64x2(): BinaryenOp
    fun BinaryenLoadExtUVec32x2ToVecI64x2(): BinaryenOp
    fun BinaryenNarrowSVecI16x8ToVecI8x16(): BinaryenOp
    fun BinaryenNarrowUVecI16x8ToVecI8x16(): BinaryenOp
    fun BinaryenNarrowSVecI32x4ToVecI16x8(): BinaryenOp
    fun BinaryenNarrowUVecI32x4ToVecI16x8(): BinaryenOp
    fun BinaryenWidenLowSVecI8x16ToVecI16x8(): BinaryenOp
    fun BinaryenWidenHighSVecI8x16ToVecI16x8(): BinaryenOp
    fun BinaryenWidenLowUVecI8x16ToVecI16x8(): BinaryenOp
    fun BinaryenWidenHighUVecI8x16ToVecI16x8(): BinaryenOp
    fun BinaryenWidenLowSVecI16x8ToVecI32x4(): BinaryenOp
    fun BinaryenWidenHighSVecI16x8ToVecI32x4(): BinaryenOp
    fun BinaryenWidenLowUVecI16x8ToVecI32x4(): BinaryenOp
    fun BinaryenWidenHighUVecI16x8ToVecI32x4(): BinaryenOp
    fun BinaryenSwizzleVec8x16(): BinaryenOp
    fun BinaryenBlock(module: BinaryenModuleRef, name: String?, children: Array<BinaryenExpressionRef>?, numChildren: BinaryenIndex, type: BinaryenType): BinaryenExpressionRef
    fun BinaryenIf(module: BinaryenModuleRef, condition: BinaryenExpressionRef, ifTrue: BinaryenExpressionRef, ifFalse: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenLoop(module: BinaryenModuleRef, `in`: String?, body: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenBreak(module: BinaryenModuleRef, name: String?, condition: BinaryenExpressionRef, value: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenSwitch(module: BinaryenModuleRef, names: Array<String>?, numNames: BinaryenIndex, defaultName: String?, condition: BinaryenExpressionRef, value: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenCall(module: BinaryenModuleRef, target: String?, operands: Array<BinaryenExpressionRef>?, numOperands: BinaryenIndex, returnType: BinaryenType): BinaryenExpressionRef
    fun BinaryenCallIndirect(module: BinaryenModuleRef, target: BinaryenExpressionRef, operands: Array<BinaryenExpressionRef>?, numOperands: BinaryenIndex, type: String?): BinaryenExpressionRef
    fun BinaryenReturnCall(module: BinaryenModuleRef, target: String?, operands: Array<BinaryenExpressionRef>?, numOperands: BinaryenIndex, returnType: BinaryenType): BinaryenExpressionRef
    fun BinaryenReturnCallIndirect(module: BinaryenModuleRef, target: BinaryenExpressionRef, operands: Array<BinaryenExpressionRef>?, numOperands: BinaryenIndex, type: String?): BinaryenExpressionRef
    fun BinaryenLocalGet(module: BinaryenModuleRef, index: BinaryenIndex, type: BinaryenType): BinaryenExpressionRef
    fun BinaryenLocalSet(module: BinaryenModuleRef, index: BinaryenIndex, value: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenLocalTee(module: BinaryenModuleRef, index: BinaryenIndex, value: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenGlobalGet(module: BinaryenModuleRef, name: String?, type: BinaryenType): BinaryenExpressionRef
    fun BinaryenGlobalSet(module: BinaryenModuleRef, name: String?, value: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenLoad(module: BinaryenModuleRef, bytes: Int, signed_: Byte, offset: Int, align: Int, type: BinaryenType, ptr: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenStore(module: BinaryenModuleRef, bytes: Int, offset: Int, align: Int, ptr: BinaryenExpressionRef, value: BinaryenExpressionRef, type: BinaryenType): BinaryenExpressionRef
    fun BinaryenConst(module: BinaryenModuleRef, value: BinaryenLiteral): BinaryenExpressionRef
    fun BinaryenUnary(module: BinaryenModuleRef, op: BinaryenOp, value: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenBinary(module: BinaryenModuleRef, op: BinaryenOp, left: BinaryenExpressionRef, right: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenSelect(module: BinaryenModuleRef, condition: BinaryenExpressionRef, ifTrue: BinaryenExpressionRef, ifFalse: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenDrop(module: BinaryenModuleRef, value: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenReturn(module: BinaryenModuleRef, value: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenHost(module: BinaryenModuleRef, op: BinaryenOp, name: String?, operands: Array<BinaryenExpressionRef>?, numOperands: BinaryenIndex): BinaryenExpressionRef
    fun BinaryenNop(module: BinaryenModuleRef): BinaryenExpressionRef
    fun BinaryenUnreachable(module: BinaryenModuleRef): BinaryenExpressionRef
    fun BinaryenAtomicLoad(module: BinaryenModuleRef, bytes: Int, offset: Int, type: BinaryenType, ptr: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenAtomicStore(module: BinaryenModuleRef, bytes: Int, offset: Int, ptr: BinaryenExpressionRef, value: BinaryenExpressionRef, type: BinaryenType): BinaryenExpressionRef
    fun BinaryenAtomicRMW(module: BinaryenModuleRef, op: BinaryenOp, bytes: BinaryenIndex, offset: BinaryenIndex, ptr: BinaryenExpressionRef, value: BinaryenExpressionRef, type: BinaryenType): BinaryenExpressionRef
    fun BinaryenAtomicCmpxchg(module: BinaryenModuleRef, bytes: BinaryenIndex, offset: BinaryenIndex, ptr: BinaryenExpressionRef, expected: BinaryenExpressionRef, replacement: BinaryenExpressionRef, type: BinaryenType): BinaryenExpressionRef
    fun BinaryenAtomicWait(module: BinaryenModuleRef, ptr: BinaryenExpressionRef, expected: BinaryenExpressionRef, timeout: BinaryenExpressionRef, type: BinaryenType): BinaryenExpressionRef
    fun BinaryenAtomicNotify(module: BinaryenModuleRef, ptr: BinaryenExpressionRef, notifyCount: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenAtomicFence(module: BinaryenModuleRef): BinaryenExpressionRef
    fun BinaryenSIMDExtract(module: BinaryenModuleRef, op: BinaryenOp, vec: BinaryenExpressionRef, index: Byte): BinaryenExpressionRef
    fun BinaryenSIMDReplace(module: BinaryenModuleRef, op: BinaryenOp, vec: BinaryenExpressionRef, index: Byte, value: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenSIMDShuffle(module: BinaryenModuleRef, left: BinaryenExpressionRef, right: BinaryenExpressionRef, mask: ByteArray?): BinaryenExpressionRef
    fun BinaryenSIMDTernary(module: BinaryenModuleRef, op: BinaryenOp, a: BinaryenExpressionRef, b: BinaryenExpressionRef, c: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenSIMDShift(module: BinaryenModuleRef, op: BinaryenOp, vec: BinaryenExpressionRef, shift: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenSIMDLoad(module: BinaryenModuleRef, op: BinaryenOp, offset: Int, align: Int, ptr: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenMemoryInit(module: BinaryenModuleRef, segment: Int, dest: BinaryenExpressionRef, offset: BinaryenExpressionRef, size: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenDataDrop(module: BinaryenModuleRef, segment: Int): BinaryenExpressionRef
    fun BinaryenMemoryCopy(module: BinaryenModuleRef, dest: BinaryenExpressionRef, source: BinaryenExpressionRef, size: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenMemoryFill(module: BinaryenModuleRef, dest: BinaryenExpressionRef, value: BinaryenExpressionRef, size: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenTry(module: BinaryenModuleRef, body: BinaryenExpressionRef, catchBody: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenThrow(module: BinaryenModuleRef, event: String?, operands: Array<BinaryenExpressionRef>?, numOperands: BinaryenIndex): BinaryenExpressionRef
    fun BinaryenRethrow(module: BinaryenModuleRef, exnref: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenBrOnExn(module: BinaryenModuleRef, name: String?, eventName: String?, exnref: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenPush(module: BinaryenModuleRef, value: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenPop(module: BinaryenModuleRef, type: BinaryenType): BinaryenExpressionRef
    fun BinaryenExpressionGetId(expr: BinaryenExpressionRef): BinaryenExpressionId
    fun BinaryenExpressionGetType(expr: BinaryenExpressionRef): BinaryenType
    fun BinaryenExpressionPrint(expr: BinaryenExpressionRef)
    fun BinaryenBlockGetName(expr: BinaryenExpressionRef): String
    fun BinaryenBlockGetNumChildren(expr: BinaryenExpressionRef): BinaryenIndex
    fun BinaryenBlockGetChild(expr: BinaryenExpressionRef, index: BinaryenIndex): BinaryenExpressionRef
    fun BinaryenIfGetCondition(expr: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenIfGetIfTrue(expr: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenIfGetIfFalse(expr: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenLoopGetName(expr: BinaryenExpressionRef): String
    fun BinaryenLoopGetBody(expr: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenBreakGetName(expr: BinaryenExpressionRef): String
    fun BinaryenBreakGetCondition(expr: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenBreakGetValue(expr: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenSwitchGetNumNames(expr: BinaryenExpressionRef): BinaryenIndex
    fun BinaryenSwitchGetName(expr: BinaryenExpressionRef, index: BinaryenIndex): String
    fun BinaryenSwitchGetDefaultName(expr: BinaryenExpressionRef): String
    fun BinaryenSwitchGetCondition(expr: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenSwitchGetValue(expr: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenCallGetTarget(expr: BinaryenExpressionRef): String
    fun BinaryenCallGetNumOperands(expr: BinaryenExpressionRef): BinaryenIndex
    fun BinaryenCallGetOperand(expr: BinaryenExpressionRef, index: BinaryenIndex): BinaryenExpressionRef
    fun BinaryenCallIndirectGetTarget(expr: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenCallIndirectGetNumOperands(expr: BinaryenExpressionRef): BinaryenIndex
    fun BinaryenCallIndirectGetOperand(expr: BinaryenExpressionRef, index: BinaryenIndex): BinaryenExpressionRef
    fun BinaryenLocalGetGetIndex(expr: BinaryenExpressionRef): BinaryenIndex
    fun BinaryenLocalSetIsTee(expr: BinaryenExpressionRef): Int
    fun BinaryenLocalSetGetIndex(expr: BinaryenExpressionRef): BinaryenIndex
    fun BinaryenLocalSetGetValue(expr: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenGlobalGetGetName(expr: BinaryenExpressionRef): String
    fun BinaryenGlobalSetGetName(expr: BinaryenExpressionRef): String
    fun BinaryenGlobalSetGetValue(expr: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenHostGetOp(expr: BinaryenExpressionRef): BinaryenOp
    fun BinaryenHostGetNameOperand(expr: BinaryenExpressionRef): String
    fun BinaryenHostGetNumOperands(expr: BinaryenExpressionRef): BinaryenIndex
    fun BinaryenHostGetOperand(expr: BinaryenExpressionRef, index: BinaryenIndex): BinaryenExpressionRef
    fun BinaryenLoadIsAtomic(expr: BinaryenExpressionRef): Int
    fun BinaryenLoadIsSigned(expr: BinaryenExpressionRef): Int
    fun BinaryenLoadGetOffset(expr: BinaryenExpressionRef): Int
    fun BinaryenLoadGetBytes(expr: BinaryenExpressionRef): Int
    fun BinaryenLoadGetAlign(expr: BinaryenExpressionRef): Int
    fun BinaryenLoadGetPtr(expr: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenStoreIsAtomic(expr: BinaryenExpressionRef): Int
    fun BinaryenStoreGetBytes(expr: BinaryenExpressionRef): Int
    fun BinaryenStoreGetOffset(expr: BinaryenExpressionRef): Int
    fun BinaryenStoreGetAlign(expr: BinaryenExpressionRef): Int
    fun BinaryenStoreGetPtr(expr: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenStoreGetValue(expr: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenConstGetValueI32(expr: BinaryenExpressionRef): Int
    fun BinaryenConstGetValueI64(expr: BinaryenExpressionRef): Long
    fun BinaryenConstGetValueI64Low(expr: BinaryenExpressionRef): Int
    fun BinaryenConstGetValueI64High(expr: BinaryenExpressionRef): Int
    fun BinaryenConstGetValueF32(expr: BinaryenExpressionRef): Float
    fun BinaryenConstGetValueF64(expr: BinaryenExpressionRef): Double
    fun BinaryenConstGetValueV128(expr: BinaryenExpressionRef, out: ByteArray?)
    fun BinaryenUnaryGetOp(expr: BinaryenExpressionRef): BinaryenOp
    fun BinaryenUnaryGetValue(expr: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenBinaryGetOp(expr: BinaryenExpressionRef): BinaryenOp
    fun BinaryenBinaryGetLeft(expr: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenBinaryGetRight(expr: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenSelectGetIfTrue(expr: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenSelectGetIfFalse(expr: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenSelectGetCondition(expr: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenDropGetValue(expr: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenReturnGetValue(expr: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenAtomicRMWGetOp(expr: BinaryenExpressionRef): BinaryenOp
    fun BinaryenAtomicRMWGetBytes(expr: BinaryenExpressionRef): Int
    fun BinaryenAtomicRMWGetOffset(expr: BinaryenExpressionRef): Int
    fun BinaryenAtomicRMWGetPtr(expr: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenAtomicRMWGetValue(expr: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenAtomicCmpxchgGetBytes(expr: BinaryenExpressionRef): Int
    fun BinaryenAtomicCmpxchgGetOffset(expr: BinaryenExpressionRef): Int
    fun BinaryenAtomicCmpxchgGetPtr(expr: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenAtomicCmpxchgGetExpected(expr: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenAtomicCmpxchgGetReplacement(expr: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenAtomicWaitGetPtr(expr: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenAtomicWaitGetExpected(expr: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenAtomicWaitGetTimeout(expr: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenAtomicWaitGetExpectedType(expr: BinaryenExpressionRef): BinaryenType
    fun BinaryenAtomicNotifyGetPtr(expr: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenAtomicNotifyGetNotifyCount(expr: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenAtomicFenceGetOrder(expr: BinaryenExpressionRef): Byte
    fun BinaryenSIMDExtractGetOp(expr: BinaryenExpressionRef): BinaryenOp
    fun BinaryenSIMDExtractGetVec(expr: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenSIMDExtractGetIndex(expr: BinaryenExpressionRef): Byte
    fun BinaryenSIMDReplaceGetOp(expr: BinaryenExpressionRef): BinaryenOp
    fun BinaryenSIMDReplaceGetVec(expr: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenSIMDReplaceGetIndex(expr: BinaryenExpressionRef): Byte
    fun BinaryenSIMDReplaceGetValue(expr: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenSIMDShuffleGetLeft(expr: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenSIMDShuffleGetRight(expr: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenSIMDShuffleGetMask(expr: BinaryenExpressionRef, mask: ByteArray?)
    fun BinaryenSIMDTernaryGetOp(expr: BinaryenExpressionRef): BinaryenOp
    fun BinaryenSIMDTernaryGetA(expr: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenSIMDTernaryGetB(expr: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenSIMDTernaryGetC(expr: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenSIMDShiftGetOp(expr: BinaryenExpressionRef): BinaryenOp
    fun BinaryenSIMDShiftGetVec(expr: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenSIMDShiftGetShift(expr: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenSIMDLoadGetOp(expr: BinaryenExpressionRef): BinaryenOp
    fun BinaryenSIMDLoadGetOffset(expr: BinaryenExpressionRef): Int
    fun BinaryenSIMDLoadGetAlign(expr: BinaryenExpressionRef): Int
    fun BinaryenSIMDLoadGetPtr(expr: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenMemoryInitGetSegment(expr: BinaryenExpressionRef): Int
    fun BinaryenMemoryInitGetDest(expr: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenMemoryInitGetOffset(expr: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenMemoryInitGetSize(expr: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenDataDropGetSegment(expr: BinaryenExpressionRef): Int
    fun BinaryenMemoryCopyGetDest(expr: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenMemoryCopyGetSource(expr: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenMemoryCopyGetSize(expr: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenMemoryFillGetDest(expr: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenMemoryFillGetValue(expr: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenMemoryFillGetSize(expr: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenTryGetBody(expr: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenTryGetCatchBody(expr: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenThrowGetEvent(expr: BinaryenExpressionRef): String
    fun BinaryenThrowGetOperand(expr: BinaryenExpressionRef, index: BinaryenIndex): BinaryenExpressionRef
    fun BinaryenThrowGetNumOperands(expr: BinaryenExpressionRef): BinaryenIndex
    fun BinaryenRethrowGetExnref(expr: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenBrOnExnGetEvent(expr: BinaryenExpressionRef): String
    fun BinaryenBrOnExnGetName(expr: BinaryenExpressionRef): String
    fun BinaryenBrOnExnGetExnref(expr: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenPushGetValue(expr: BinaryenExpressionRef): BinaryenExpressionRef
    fun BinaryenAddFunction(module: BinaryenModuleRef, name: String?, type: BinaryenFunctionTypeRef, varTypes: IntArray?, numVarTypes: BinaryenIndex, body: BinaryenExpressionRef): BinaryenFunctionRef
    fun BinaryenGetFunction(module: BinaryenModuleRef, name: String?): BinaryenFunctionRef
    fun BinaryenRemoveFunction(module: BinaryenModuleRef, name: String?)
    fun BinaryenAddFunctionImport(module: BinaryenModuleRef, internalName: String?, externalModuleName: String?, externalBaseName: String?, functionType: BinaryenFunctionTypeRef)
    fun BinaryenAddTableImport(module: BinaryenModuleRef, internalName: String?, externalModuleName: String?, externalBaseName: String?)
    fun BinaryenAddMemoryImport(module: BinaryenModuleRef, internalName: String?, externalModuleName: String?, externalBaseName: String?, shared: Byte)
    fun BinaryenAddGlobalImport(module: BinaryenModuleRef, internalName: String?, externalModuleName: String?, externalBaseName: String?, globalType: BinaryenType, mutable_: Int)
    fun BinaryenAddEventImport(module: BinaryenModuleRef, internalName: String?, externalModuleName: String?, externalBaseName: String?, attribute: Int, eventType: BinaryenFunctionTypeRef)
    fun BinaryenAddFunctionExport(module: BinaryenModuleRef, internalName: String?, externalName: String?): BinaryenExportRef
    fun BinaryenAddTableExport(module: BinaryenModuleRef, internalName: String?, externalName: String?): BinaryenExportRef
    fun BinaryenAddMemoryExport(module: BinaryenModuleRef, internalName: String?, externalName: String?): BinaryenExportRef
    fun BinaryenAddGlobalExport(module: BinaryenModuleRef, internalName: String?, externalName: String?): BinaryenExportRef
    fun BinaryenAddEventExport(module: BinaryenModuleRef, internalName: String?, externalName: String?): BinaryenExportRef
    fun BinaryenRemoveExport(module: BinaryenModuleRef, externalName: String?)
    fun BinaryenAddGlobal(module: BinaryenModuleRef, name: String?, type: BinaryenType, mutable_: Byte, init: BinaryenExpressionRef): BinaryenGlobalRef
    fun BinaryenGetGlobal(module: BinaryenModuleRef, name: String?): BinaryenGlobalRef
    fun BinaryenRemoveGlobal(module: BinaryenModuleRef, name: String?)
    fun BinaryenAddEvent(module: BinaryenModuleRef, name: String?, attribute: Int, type: BinaryenFunctionTypeRef): BinaryenEventRef
    fun BinaryenGetEvent(module: BinaryenModuleRef, name: String?): BinaryenEventRef
    fun BinaryenRemoveEvent(module: BinaryenModuleRef, name: String?)
    fun BinaryenSetFunctionTable(module: BinaryenModuleRef, initial: BinaryenIndex, maximum: BinaryenIndex, funcNames: Array<String>?, numFuncNames: BinaryenIndex, offset: BinaryenExpressionRef)
    fun BinaryenSetMemory(module: BinaryenModuleRef, initial: BinaryenIndex, maximum: BinaryenIndex, exportName: String?, segments: Array<String>?, segmentPassive: ByteArray?, segmentOffsets: Array<BinaryenExpressionRef>?, segmentSizes: IntArray?, numSegments: BinaryenIndex, shared: Byte)
    fun BinaryenSetStart(module: BinaryenModuleRef, start: BinaryenFunctionRef)
    fun BinaryenModuleGetFeatures(module: BinaryenModuleRef): BinaryenFeatures
    fun BinaryenModuleSetFeatures(module: BinaryenModuleRef, features: BinaryenFeatures)
    fun BinaryenModuleParse(text: String?): BinaryenModuleRef
    fun BinaryenModulePrint(module: BinaryenModuleRef)
    fun BinaryenModulePrintAsmjs(module: BinaryenModuleRef)
    fun BinaryenModuleValidate(module: BinaryenModuleRef): Int
    fun BinaryenModuleOptimize(module: BinaryenModuleRef)
    fun BinaryenGetOptimizeLevel(): Int
    fun BinaryenSetOptimizeLevel(level: Int)
    fun BinaryenGetShrinkLevel(): Int
    fun BinaryenSetShrinkLevel(level: Int)
    fun BinaryenGetDebugInfo(): Int
    fun BinaryenSetDebugInfo(on: Int)
    fun BinaryenModuleRunPasses(module: BinaryenModuleRef, passes: Array<String>?, numPasses: BinaryenIndex)
    fun BinaryenModuleAutoDrop(module: BinaryenModuleRef)
    fun BinaryenModuleWrite(module: BinaryenModuleRef, output: String?, outputSize: Int): Int
    fun BinaryenModuleWriteText(module: BinaryenModuleRef, output: String?, outputSize: Int): Int
    fun BinaryenModuleWriteWithSourceMap(module: BinaryenModuleRef, url: String?, output: String?, outputSize: Int, sourceMap: String?, sourceMapSize: Int): BinaryenBufferSizes
    fun BinaryenModuleAllocateAndWrite(module: BinaryenModuleRef, sourceMapUrl: String?): BinaryenModuleAllocateAndWriteResult
    fun BinaryenModuleAllocateAndWriteText(module: Array<BinaryenModuleRef>?): String
    fun BinaryenModuleRead(input: String?, inputSize: Int): BinaryenModuleRef
    fun BinaryenModuleInterpret(module: BinaryenModuleRef)
    fun BinaryenModuleAddDebugInfoFileName(module: BinaryenModuleRef, filename: String?): BinaryenIndex
    fun BinaryenModuleGetDebugInfoFileName(module: BinaryenModuleRef, index: BinaryenIndex): String
    fun BinaryenFunctionTypeGetName(ftype: BinaryenFunctionTypeRef): String
    fun BinaryenFunctionTypeGetNumParams(ftype: BinaryenFunctionTypeRef): BinaryenIndex
    fun BinaryenFunctionTypeGetParam(ftype: BinaryenFunctionTypeRef, index: BinaryenIndex): BinaryenType
    fun BinaryenFunctionTypeGetResult(ftype: BinaryenFunctionTypeRef): BinaryenType
    fun BinaryenFunctionGetName(func: BinaryenFunctionRef): String
    fun BinaryenFunctionGetType(func: BinaryenFunctionRef): String
    fun BinaryenFunctionGetNumParams(func: BinaryenFunctionRef): BinaryenIndex
    fun BinaryenFunctionGetParam(func: BinaryenFunctionRef, index: BinaryenIndex): BinaryenType
    fun BinaryenFunctionGetResult(func: BinaryenFunctionRef): BinaryenType
    fun BinaryenFunctionGetNumVars(func: BinaryenFunctionRef): BinaryenIndex
    fun BinaryenFunctionGetVar(func: BinaryenFunctionRef, index: BinaryenIndex): BinaryenType
    fun BinaryenFunctionGetBody(func: BinaryenFunctionRef): BinaryenExpressionRef
    fun BinaryenFunctionOptimize(func: BinaryenFunctionRef, module: BinaryenModuleRef)
    fun BinaryenFunctionRunPasses(func: BinaryenFunctionRef, module: BinaryenModuleRef, passes: Array<String>?, numPasses: BinaryenIndex)
    fun BinaryenFunctionSetDebugLocation(func: BinaryenFunctionRef, expr: BinaryenExpressionRef, fileIndex: BinaryenIndex, lineNumber: BinaryenIndex, columnNumber: BinaryenIndex)
    fun BinaryenGlobalGetName(global: BinaryenGlobalRef): String
    fun BinaryenGlobalGetType(global: BinaryenGlobalRef): BinaryenType
    fun BinaryenGlobalIsMutable(global: BinaryenGlobalRef): Int
    fun BinaryenGlobalGetInitExpr(global: BinaryenGlobalRef): BinaryenExpressionRef
    fun BinaryenEventGetName(event: BinaryenEventRef): String
    fun BinaryenEventGetAttribute(event: BinaryenEventRef): Int
    fun BinaryenEventGetType(event: BinaryenEventRef): String
    fun BinaryenEventGetNumParams(event: BinaryenEventRef): BinaryenIndex
    fun BinaryenEventGetParam(event: BinaryenEventRef, index: BinaryenIndex): BinaryenType
    fun BinaryenFunctionImportGetModule(import: BinaryenFunctionRef): String
    fun BinaryenGlobalImportGetModule(import: BinaryenGlobalRef): String
    fun BinaryenEventImportGetModule(import: BinaryenEventRef): String
    fun BinaryenFunctionImportGetBase(import: BinaryenFunctionRef): String
    fun BinaryenGlobalImportGetBase(import: BinaryenGlobalRef): String
    fun BinaryenEventImportGetBase(import: BinaryenEventRef): String
    fun BinaryenExportGetKind(export_: BinaryenExportRef): BinaryenExternalKind
    fun BinaryenExportGetName(export_: BinaryenExportRef): String
    fun BinaryenExportGetValue(export_: BinaryenExportRef): String
    fun BinaryenAddCustomSection(module: BinaryenModuleRef, name: String?, contents: String?, contentsSize: BinaryenIndex)
    fun RelooperCreate(module: BinaryenModuleRef): RelooperRef
    fun RelooperAddBlock(relooper: RelooperRef, code: BinaryenExpressionRef): RelooperBlockRef
    fun RelooperAddBranch(from: RelooperBlockRef, to: RelooperBlockRef, condition: BinaryenExpressionRef, code: BinaryenExpressionRef)
    fun RelooperAddBlockWithSwitch(relooper: RelooperRef, code: BinaryenExpressionRef, condition: BinaryenExpressionRef): RelooperBlockRef
    fun RelooperAddBranchForSwitch(from: RelooperBlockRef, to: RelooperBlockRef, indexes: IntArray?, numIndexes: BinaryenIndex, code: BinaryenExpressionRef)
    fun RelooperRenderAndDispose(relooper: RelooperRef, entry: RelooperBlockRef, labelHelper: BinaryenIndex): BinaryenExpressionRef
    fun BinaryenSetAPITracing(on: Int)
    fun BinaryenGetFunctionTypeBySignature(module: BinaryenModuleRef, result: BinaryenType, paramTypes: IntArray?, numParams: BinaryenIndex): BinaryenFunctionTypeRef
    fun BinaryenSetColorsEnabled(enabled: Int)
    fun BinaryenAreColorsEnabled(): Int

}

