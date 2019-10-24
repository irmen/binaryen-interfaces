/* preprocessed binaryen-c.h header file in case no source is found */
typedef uint32_t BinaryenIndex;
typedef uint32_t BinaryenType;
 BinaryenType BinaryenTypeNone(void);
 BinaryenType BinaryenTypeInt32(void);
 BinaryenType BinaryenTypeInt64(void);
 BinaryenType BinaryenTypeFloat32(void);
 BinaryenType BinaryenTypeFloat64(void);
 BinaryenType BinaryenTypeVec128(void);
 BinaryenType BinaryenTypeAnyref(void);
 BinaryenType BinaryenTypeExnref(void);
 BinaryenType BinaryenTypeUnreachable(void);
 BinaryenType BinaryenTypeAuto(void);
typedef uint32_t BinaryenExpressionId;
 BinaryenExpressionId BinaryenInvalidId(void);
 BinaryenExpressionId BinaryenBlockId(void);
 BinaryenExpressionId BinaryenIfId(void);
 BinaryenExpressionId BinaryenLoopId(void);
 BinaryenExpressionId BinaryenBreakId(void);
 BinaryenExpressionId BinaryenSwitchId(void);
 BinaryenExpressionId BinaryenCallId(void);
 BinaryenExpressionId BinaryenCallIndirectId(void);
 BinaryenExpressionId BinaryenLocalGetId(void);
 BinaryenExpressionId BinaryenLocalSetId(void);
 BinaryenExpressionId BinaryenGlobalGetId(void);
 BinaryenExpressionId BinaryenGlobalSetId(void);
 BinaryenExpressionId BinaryenLoadId(void);
 BinaryenExpressionId BinaryenStoreId(void);
 BinaryenExpressionId BinaryenConstId(void);
 BinaryenExpressionId BinaryenUnaryId(void);
 BinaryenExpressionId BinaryenBinaryId(void);
 BinaryenExpressionId BinaryenSelectId(void);
 BinaryenExpressionId BinaryenDropId(void);
 BinaryenExpressionId BinaryenReturnId(void);
 BinaryenExpressionId BinaryenHostId(void);
 BinaryenExpressionId BinaryenNopId(void);
 BinaryenExpressionId BinaryenUnreachableId(void);
 BinaryenExpressionId BinaryenAtomicCmpxchgId(void);
 BinaryenExpressionId BinaryenAtomicRMWId(void);
 BinaryenExpressionId BinaryenAtomicWaitId(void);
 BinaryenExpressionId BinaryenAtomicNotifyId(void);
 BinaryenExpressionId BinaryenAtomicFenceId(void);
 BinaryenExpressionId BinaryenSIMDExtractId(void);
 BinaryenExpressionId BinaryenSIMDReplaceId(void);
 BinaryenExpressionId BinaryenSIMDShuffleId(void);
 BinaryenExpressionId BinaryenSIMDTernaryId(void);
 BinaryenExpressionId BinaryenSIMDShiftId(void);
 BinaryenExpressionId BinaryenSIMDLoadId(void);
 BinaryenExpressionId BinaryenMemoryInitId(void);
 BinaryenExpressionId BinaryenDataDropId(void);
 BinaryenExpressionId BinaryenMemoryCopyId(void);
 BinaryenExpressionId BinaryenMemoryFillId(void);
 BinaryenExpressionId BinaryenTryId(void);
 BinaryenExpressionId BinaryenThrowId(void);
 BinaryenExpressionId BinaryenRethrowId(void);
 BinaryenExpressionId BinaryenBrOnExnId(void);
 BinaryenExpressionId BinaryenPushId(void);
 BinaryenExpressionId BinaryenPopId(void);
typedef uint32_t BinaryenExternalKind;
 BinaryenExternalKind BinaryenExternalFunction(void);
 BinaryenExternalKind BinaryenExternalTable(void);
 BinaryenExternalKind BinaryenExternalMemory(void);
 BinaryenExternalKind BinaryenExternalGlobal(void);
 BinaryenExternalKind BinaryenExternalEvent(void);
typedef uint32_t BinaryenFeatures;
 BinaryenFeatures BinaryenFeatureMVP(void);
 BinaryenFeatures BinaryenFeatureAtomics(void);
 BinaryenFeatures BinaryenFeatureBulkMemory(void);
 BinaryenFeatures BinaryenFeatureMutableGlobals(void);
 BinaryenFeatures BinaryenFeatureNontrappingFPToInt(void);
 BinaryenFeatures BinaryenFeatureSignExt(void);
 BinaryenFeatures BinaryenFeatureSIMD128(void);
 BinaryenFeatures BinaryenFeatureExceptionHandling(void);
 BinaryenFeatures BinaryenFeatureTailCall(void);
 BinaryenFeatures BinaryenFeatureReferenceTypes(void);
 BinaryenFeatures BinaryenFeatureAll(void);
typedef void* BinaryenModuleRef;
 BinaryenModuleRef BinaryenModuleCreate(void);
 void BinaryenModuleDispose(BinaryenModuleRef module);
typedef void* BinaryenFunctionTypeRef;
 BinaryenFunctionTypeRef BinaryenAddFunctionType(BinaryenModuleRef module,
                        const char* name,
                        BinaryenType result,
                        BinaryenType* paramTypes,
                        BinaryenIndex numParams);
 void BinaryenRemoveFunctionType(BinaryenModuleRef module,
                                             const char* name);
struct BinaryenLiteral {
  int32_t type;
  union {
    int32_t i32;
    int64_t i64;
    float f32;
    double f64;
    uint8_t v128[16];
  };
};
 struct BinaryenLiteral BinaryenLiteralInt32(int32_t x);
 struct BinaryenLiteral BinaryenLiteralInt64(int64_t x);
 struct BinaryenLiteral BinaryenLiteralFloat32(float x);
 struct BinaryenLiteral BinaryenLiteralFloat64(double x);
 struct BinaryenLiteral BinaryenLiteralVec128(const uint8_t x[16]);
 struct BinaryenLiteral BinaryenLiteralFloat32Bits(int32_t x);
 struct BinaryenLiteral BinaryenLiteralFloat64Bits(int64_t x);
typedef int32_t BinaryenOp;
 BinaryenOp BinaryenClzInt32(void);
 BinaryenOp BinaryenCtzInt32(void);
 BinaryenOp BinaryenPopcntInt32(void);
 BinaryenOp BinaryenNegFloat32(void);
 BinaryenOp BinaryenAbsFloat32(void);
 BinaryenOp BinaryenCeilFloat32(void);
 BinaryenOp BinaryenFloorFloat32(void);
 BinaryenOp BinaryenTruncFloat32(void);
 BinaryenOp BinaryenNearestFloat32(void);
 BinaryenOp BinaryenSqrtFloat32(void);
 BinaryenOp BinaryenEqZInt32(void);
 BinaryenOp BinaryenClzInt64(void);
 BinaryenOp BinaryenCtzInt64(void);
 BinaryenOp BinaryenPopcntInt64(void);
 BinaryenOp BinaryenNegFloat64(void);
 BinaryenOp BinaryenAbsFloat64(void);
 BinaryenOp BinaryenCeilFloat64(void);
 BinaryenOp BinaryenFloorFloat64(void);
 BinaryenOp BinaryenTruncFloat64(void);
 BinaryenOp BinaryenNearestFloat64(void);
 BinaryenOp BinaryenSqrtFloat64(void);
 BinaryenOp BinaryenEqZInt64(void);
 BinaryenOp BinaryenExtendSInt32(void);
 BinaryenOp BinaryenExtendUInt32(void);
 BinaryenOp BinaryenWrapInt64(void);
 BinaryenOp BinaryenTruncSFloat32ToInt32(void);
 BinaryenOp BinaryenTruncSFloat32ToInt64(void);
 BinaryenOp BinaryenTruncUFloat32ToInt32(void);
 BinaryenOp BinaryenTruncUFloat32ToInt64(void);
 BinaryenOp BinaryenTruncSFloat64ToInt32(void);
 BinaryenOp BinaryenTruncSFloat64ToInt64(void);
 BinaryenOp BinaryenTruncUFloat64ToInt32(void);
 BinaryenOp BinaryenTruncUFloat64ToInt64(void);
 BinaryenOp BinaryenReinterpretFloat32(void);
 BinaryenOp BinaryenReinterpretFloat64(void);
 BinaryenOp BinaryenConvertSInt32ToFloat32(void);
 BinaryenOp BinaryenConvertSInt32ToFloat64(void);
 BinaryenOp BinaryenConvertUInt32ToFloat32(void);
 BinaryenOp BinaryenConvertUInt32ToFloat64(void);
 BinaryenOp BinaryenConvertSInt64ToFloat32(void);
 BinaryenOp BinaryenConvertSInt64ToFloat64(void);
 BinaryenOp BinaryenConvertUInt64ToFloat32(void);
 BinaryenOp BinaryenConvertUInt64ToFloat64(void);
 BinaryenOp BinaryenPromoteFloat32(void);
 BinaryenOp BinaryenDemoteFloat64(void);
 BinaryenOp BinaryenReinterpretInt32(void);
 BinaryenOp BinaryenReinterpretInt64(void);
 BinaryenOp BinaryenExtendS8Int32(void);
 BinaryenOp BinaryenExtendS16Int32(void);
 BinaryenOp BinaryenExtendS8Int64(void);
 BinaryenOp BinaryenExtendS16Int64(void);
 BinaryenOp BinaryenExtendS32Int64(void);
 BinaryenOp BinaryenAddInt32(void);
 BinaryenOp BinaryenSubInt32(void);
 BinaryenOp BinaryenMulInt32(void);
 BinaryenOp BinaryenDivSInt32(void);
 BinaryenOp BinaryenDivUInt32(void);
 BinaryenOp BinaryenRemSInt32(void);
 BinaryenOp BinaryenRemUInt32(void);
 BinaryenOp BinaryenAndInt32(void);
 BinaryenOp BinaryenOrInt32(void);
 BinaryenOp BinaryenXorInt32(void);
 BinaryenOp BinaryenShlInt32(void);
 BinaryenOp BinaryenShrUInt32(void);
 BinaryenOp BinaryenShrSInt32(void);
 BinaryenOp BinaryenRotLInt32(void);
 BinaryenOp BinaryenRotRInt32(void);
 BinaryenOp BinaryenEqInt32(void);
 BinaryenOp BinaryenNeInt32(void);
 BinaryenOp BinaryenLtSInt32(void);
 BinaryenOp BinaryenLtUInt32(void);
 BinaryenOp BinaryenLeSInt32(void);
 BinaryenOp BinaryenLeUInt32(void);
 BinaryenOp BinaryenGtSInt32(void);
 BinaryenOp BinaryenGtUInt32(void);
 BinaryenOp BinaryenGeSInt32(void);
 BinaryenOp BinaryenGeUInt32(void);
 BinaryenOp BinaryenAddInt64(void);
 BinaryenOp BinaryenSubInt64(void);
 BinaryenOp BinaryenMulInt64(void);
 BinaryenOp BinaryenDivSInt64(void);
 BinaryenOp BinaryenDivUInt64(void);
 BinaryenOp BinaryenRemSInt64(void);
 BinaryenOp BinaryenRemUInt64(void);
 BinaryenOp BinaryenAndInt64(void);
 BinaryenOp BinaryenOrInt64(void);
 BinaryenOp BinaryenXorInt64(void);
 BinaryenOp BinaryenShlInt64(void);
 BinaryenOp BinaryenShrUInt64(void);
 BinaryenOp BinaryenShrSInt64(void);
 BinaryenOp BinaryenRotLInt64(void);
 BinaryenOp BinaryenRotRInt64(void);
 BinaryenOp BinaryenEqInt64(void);
 BinaryenOp BinaryenNeInt64(void);
 BinaryenOp BinaryenLtSInt64(void);
 BinaryenOp BinaryenLtUInt64(void);
 BinaryenOp BinaryenLeSInt64(void);
 BinaryenOp BinaryenLeUInt64(void);
 BinaryenOp BinaryenGtSInt64(void);
 BinaryenOp BinaryenGtUInt64(void);
 BinaryenOp BinaryenGeSInt64(void);
 BinaryenOp BinaryenGeUInt64(void);
 BinaryenOp BinaryenAddFloat32(void);
 BinaryenOp BinaryenSubFloat32(void);
 BinaryenOp BinaryenMulFloat32(void);
 BinaryenOp BinaryenDivFloat32(void);
 BinaryenOp BinaryenCopySignFloat32(void);
 BinaryenOp BinaryenMinFloat32(void);
 BinaryenOp BinaryenMaxFloat32(void);
 BinaryenOp BinaryenEqFloat32(void);
 BinaryenOp BinaryenNeFloat32(void);
 BinaryenOp BinaryenLtFloat32(void);
 BinaryenOp BinaryenLeFloat32(void);
 BinaryenOp BinaryenGtFloat32(void);
 BinaryenOp BinaryenGeFloat32(void);
 BinaryenOp BinaryenAddFloat64(void);
 BinaryenOp BinaryenSubFloat64(void);
 BinaryenOp BinaryenMulFloat64(void);
 BinaryenOp BinaryenDivFloat64(void);
 BinaryenOp BinaryenCopySignFloat64(void);
 BinaryenOp BinaryenMinFloat64(void);
 BinaryenOp BinaryenMaxFloat64(void);
 BinaryenOp BinaryenEqFloat64(void);
 BinaryenOp BinaryenNeFloat64(void);
 BinaryenOp BinaryenLtFloat64(void);
 BinaryenOp BinaryenLeFloat64(void);
 BinaryenOp BinaryenGtFloat64(void);
 BinaryenOp BinaryenGeFloat64(void);
 BinaryenOp BinaryenMemorySize(void);
 BinaryenOp BinaryenMemoryGrow(void);
 BinaryenOp BinaryenAtomicRMWAdd(void);
 BinaryenOp BinaryenAtomicRMWSub(void);
 BinaryenOp BinaryenAtomicRMWAnd(void);
 BinaryenOp BinaryenAtomicRMWOr(void);
 BinaryenOp BinaryenAtomicRMWXor(void);
 BinaryenOp BinaryenAtomicRMWXchg(void);
 BinaryenOp BinaryenTruncSatSFloat32ToInt32(void);
 BinaryenOp BinaryenTruncSatSFloat32ToInt64(void);
 BinaryenOp BinaryenTruncSatUFloat32ToInt32(void);
 BinaryenOp BinaryenTruncSatUFloat32ToInt64(void);
 BinaryenOp BinaryenTruncSatSFloat64ToInt32(void);
 BinaryenOp BinaryenTruncSatSFloat64ToInt64(void);
 BinaryenOp BinaryenTruncSatUFloat64ToInt32(void);
 BinaryenOp BinaryenTruncSatUFloat64ToInt64(void);
 BinaryenOp BinaryenSplatVecI8x16(void);
 BinaryenOp BinaryenExtractLaneSVecI8x16(void);
 BinaryenOp BinaryenExtractLaneUVecI8x16(void);
 BinaryenOp BinaryenReplaceLaneVecI8x16(void);
 BinaryenOp BinaryenSplatVecI16x8(void);
 BinaryenOp BinaryenExtractLaneSVecI16x8(void);
 BinaryenOp BinaryenExtractLaneUVecI16x8(void);
 BinaryenOp BinaryenReplaceLaneVecI16x8(void);
 BinaryenOp BinaryenSplatVecI32x4(void);
 BinaryenOp BinaryenExtractLaneVecI32x4(void);
 BinaryenOp BinaryenReplaceLaneVecI32x4(void);
 BinaryenOp BinaryenSplatVecI64x2(void);
 BinaryenOp BinaryenExtractLaneVecI64x2(void);
 BinaryenOp BinaryenReplaceLaneVecI64x2(void);
 BinaryenOp BinaryenSplatVecF32x4(void);
 BinaryenOp BinaryenExtractLaneVecF32x4(void);
 BinaryenOp BinaryenReplaceLaneVecF32x4(void);
 BinaryenOp BinaryenSplatVecF64x2(void);
 BinaryenOp BinaryenExtractLaneVecF64x2(void);
 BinaryenOp BinaryenReplaceLaneVecF64x2(void);
 BinaryenOp BinaryenEqVecI8x16(void);
 BinaryenOp BinaryenNeVecI8x16(void);
 BinaryenOp BinaryenLtSVecI8x16(void);
 BinaryenOp BinaryenLtUVecI8x16(void);
 BinaryenOp BinaryenGtSVecI8x16(void);
 BinaryenOp BinaryenGtUVecI8x16(void);
 BinaryenOp BinaryenLeSVecI8x16(void);
 BinaryenOp BinaryenLeUVecI8x16(void);
 BinaryenOp BinaryenGeSVecI8x16(void);
 BinaryenOp BinaryenGeUVecI8x16(void);
 BinaryenOp BinaryenEqVecI16x8(void);
 BinaryenOp BinaryenNeVecI16x8(void);
 BinaryenOp BinaryenLtSVecI16x8(void);
 BinaryenOp BinaryenLtUVecI16x8(void);
 BinaryenOp BinaryenGtSVecI16x8(void);
 BinaryenOp BinaryenGtUVecI16x8(void);
 BinaryenOp BinaryenLeSVecI16x8(void);
 BinaryenOp BinaryenLeUVecI16x8(void);
 BinaryenOp BinaryenGeSVecI16x8(void);
 BinaryenOp BinaryenGeUVecI16x8(void);
 BinaryenOp BinaryenEqVecI32x4(void);
 BinaryenOp BinaryenNeVecI32x4(void);
 BinaryenOp BinaryenLtSVecI32x4(void);
 BinaryenOp BinaryenLtUVecI32x4(void);
 BinaryenOp BinaryenGtSVecI32x4(void);
 BinaryenOp BinaryenGtUVecI32x4(void);
 BinaryenOp BinaryenLeSVecI32x4(void);
 BinaryenOp BinaryenLeUVecI32x4(void);
 BinaryenOp BinaryenGeSVecI32x4(void);
 BinaryenOp BinaryenGeUVecI32x4(void);
 BinaryenOp BinaryenEqVecF32x4(void);
 BinaryenOp BinaryenNeVecF32x4(void);
 BinaryenOp BinaryenLtVecF32x4(void);
 BinaryenOp BinaryenGtVecF32x4(void);
 BinaryenOp BinaryenLeVecF32x4(void);
 BinaryenOp BinaryenGeVecF32x4(void);
 BinaryenOp BinaryenEqVecF64x2(void);
 BinaryenOp BinaryenNeVecF64x2(void);
 BinaryenOp BinaryenLtVecF64x2(void);
 BinaryenOp BinaryenGtVecF64x2(void);
 BinaryenOp BinaryenLeVecF64x2(void);
 BinaryenOp BinaryenGeVecF64x2(void);
 BinaryenOp BinaryenNotVec128(void);
 BinaryenOp BinaryenAndVec128(void);
 BinaryenOp BinaryenOrVec128(void);
 BinaryenOp BinaryenXorVec128(void);
 BinaryenOp BinaryenAndNotVec128(void);
 BinaryenOp BinaryenBitselectVec128(void);
 BinaryenOp BinaryenNegVecI8x16(void);
 BinaryenOp BinaryenAnyTrueVecI8x16(void);
 BinaryenOp BinaryenAllTrueVecI8x16(void);
 BinaryenOp BinaryenShlVecI8x16(void);
 BinaryenOp BinaryenShrSVecI8x16(void);
 BinaryenOp BinaryenShrUVecI8x16(void);
 BinaryenOp BinaryenAddVecI8x16(void);
 BinaryenOp BinaryenAddSatSVecI8x16(void);
 BinaryenOp BinaryenAddSatUVecI8x16(void);
 BinaryenOp BinaryenSubVecI8x16(void);
 BinaryenOp BinaryenSubSatSVecI8x16(void);
 BinaryenOp BinaryenSubSatUVecI8x16(void);
 BinaryenOp BinaryenMulVecI8x16(void);
 BinaryenOp BinaryenNegVecI16x8(void);
 BinaryenOp BinaryenAnyTrueVecI16x8(void);
 BinaryenOp BinaryenAllTrueVecI16x8(void);
 BinaryenOp BinaryenShlVecI16x8(void);
 BinaryenOp BinaryenShrSVecI16x8(void);
 BinaryenOp BinaryenShrUVecI16x8(void);
 BinaryenOp BinaryenAddVecI16x8(void);
 BinaryenOp BinaryenAddSatSVecI16x8(void);
 BinaryenOp BinaryenAddSatUVecI16x8(void);
 BinaryenOp BinaryenSubVecI16x8(void);
 BinaryenOp BinaryenSubSatSVecI16x8(void);
 BinaryenOp BinaryenSubSatUVecI16x8(void);
 BinaryenOp BinaryenMulVecI16x8(void);
 BinaryenOp BinaryenNegVecI32x4(void);
 BinaryenOp BinaryenAnyTrueVecI32x4(void);
 BinaryenOp BinaryenAllTrueVecI32x4(void);
 BinaryenOp BinaryenShlVecI32x4(void);
 BinaryenOp BinaryenShrSVecI32x4(void);
 BinaryenOp BinaryenShrUVecI32x4(void);
 BinaryenOp BinaryenAddVecI32x4(void);
 BinaryenOp BinaryenSubVecI32x4(void);
 BinaryenOp BinaryenMulVecI32x4(void);
 BinaryenOp BinaryenNegVecI64x2(void);
 BinaryenOp BinaryenAnyTrueVecI64x2(void);
 BinaryenOp BinaryenAllTrueVecI64x2(void);
 BinaryenOp BinaryenShlVecI64x2(void);
 BinaryenOp BinaryenShrSVecI64x2(void);
 BinaryenOp BinaryenShrUVecI64x2(void);
 BinaryenOp BinaryenAddVecI64x2(void);
 BinaryenOp BinaryenSubVecI64x2(void);
 BinaryenOp BinaryenAbsVecF32x4(void);
 BinaryenOp BinaryenNegVecF32x4(void);
 BinaryenOp BinaryenSqrtVecF32x4(void);
 BinaryenOp BinaryenQFMAVecF32x4(void);
 BinaryenOp BinaryenQFMSVecF32x4(void);
 BinaryenOp BinaryenAddVecF32x4(void);
 BinaryenOp BinaryenSubVecF32x4(void);
 BinaryenOp BinaryenMulVecF32x4(void);
 BinaryenOp BinaryenDivVecF32x4(void);
 BinaryenOp BinaryenMinVecF32x4(void);
 BinaryenOp BinaryenMaxVecF32x4(void);
 BinaryenOp BinaryenAbsVecF64x2(void);
 BinaryenOp BinaryenNegVecF64x2(void);
 BinaryenOp BinaryenSqrtVecF64x2(void);
 BinaryenOp BinaryenQFMAVecF64x2(void);
 BinaryenOp BinaryenQFMSVecF64x2(void);
 BinaryenOp BinaryenAddVecF64x2(void);
 BinaryenOp BinaryenSubVecF64x2(void);
 BinaryenOp BinaryenMulVecF64x2(void);
 BinaryenOp BinaryenDivVecF64x2(void);
 BinaryenOp BinaryenMinVecF64x2(void);
 BinaryenOp BinaryenMaxVecF64x2(void);
 BinaryenOp BinaryenTruncSatSVecF32x4ToVecI32x4(void);
 BinaryenOp BinaryenTruncSatUVecF32x4ToVecI32x4(void);
 BinaryenOp BinaryenTruncSatSVecF64x2ToVecI64x2(void);
 BinaryenOp BinaryenTruncSatUVecF64x2ToVecI64x2(void);
 BinaryenOp BinaryenConvertSVecI32x4ToVecF32x4(void);
 BinaryenOp BinaryenConvertUVecI32x4ToVecF32x4(void);
 BinaryenOp BinaryenConvertSVecI64x2ToVecF64x2(void);
 BinaryenOp BinaryenConvertUVecI64x2ToVecF64x2(void);
 BinaryenOp BinaryenLoadSplatVec8x16(void);
 BinaryenOp BinaryenLoadSplatVec16x8(void);
 BinaryenOp BinaryenLoadSplatVec32x4(void);
 BinaryenOp BinaryenLoadSplatVec64x2(void);
 BinaryenOp BinaryenLoadExtSVec8x8ToVecI16x8(void);
 BinaryenOp BinaryenLoadExtUVec8x8ToVecI16x8(void);
 BinaryenOp BinaryenLoadExtSVec16x4ToVecI32x4(void);
 BinaryenOp BinaryenLoadExtUVec16x4ToVecI32x4(void);
 BinaryenOp BinaryenLoadExtSVec32x2ToVecI64x2(void);
 BinaryenOp BinaryenLoadExtUVec32x2ToVecI64x2(void);
 BinaryenOp BinaryenNarrowSVecI16x8ToVecI8x16(void);
 BinaryenOp BinaryenNarrowUVecI16x8ToVecI8x16(void);
 BinaryenOp BinaryenNarrowSVecI32x4ToVecI16x8(void);
 BinaryenOp BinaryenNarrowUVecI32x4ToVecI16x8(void);
 BinaryenOp BinaryenWidenLowSVecI8x16ToVecI16x8(void);
 BinaryenOp BinaryenWidenHighSVecI8x16ToVecI16x8(void);
 BinaryenOp BinaryenWidenLowUVecI8x16ToVecI16x8(void);
 BinaryenOp BinaryenWidenHighUVecI8x16ToVecI16x8(void);
 BinaryenOp BinaryenWidenLowSVecI16x8ToVecI32x4(void);
 BinaryenOp BinaryenWidenHighSVecI16x8ToVecI32x4(void);
 BinaryenOp BinaryenWidenLowUVecI16x8ToVecI32x4(void);
 BinaryenOp BinaryenWidenHighUVecI16x8ToVecI32x4(void);
 BinaryenOp BinaryenSwizzleVec8x16(void);
typedef void* BinaryenExpressionRef;
 BinaryenExpressionRef
BinaryenBlock(BinaryenModuleRef module,
              const char* name,
              BinaryenExpressionRef* children,
              BinaryenIndex numChildren,
              BinaryenType type);
 BinaryenExpressionRef BinaryenIf(BinaryenModuleRef module,
                                              BinaryenExpressionRef condition,
                                              BinaryenExpressionRef ifTrue,
                                              BinaryenExpressionRef ifFalse);
 BinaryenExpressionRef BinaryenLoop(BinaryenModuleRef module,
                                                const char* in,
                                                BinaryenExpressionRef body);
 BinaryenExpressionRef
BinaryenBreak(BinaryenModuleRef module,
              const char* name,
              BinaryenExpressionRef condition,
              BinaryenExpressionRef value);
 BinaryenExpressionRef
BinaryenSwitch(BinaryenModuleRef module,
               const char** names,
               BinaryenIndex numNames,
               const char* defaultName,
               BinaryenExpressionRef condition,
               BinaryenExpressionRef value);
 BinaryenExpressionRef BinaryenCall(BinaryenModuleRef module,
                                                const char* target,
                                                BinaryenExpressionRef* operands,
                                                BinaryenIndex numOperands,
                                                BinaryenType returnType);
 BinaryenExpressionRef
BinaryenCallIndirect(BinaryenModuleRef module,
                     BinaryenExpressionRef target,
                     BinaryenExpressionRef* operands,
                     BinaryenIndex numOperands,
                     const char* type);
 BinaryenExpressionRef
BinaryenReturnCall(BinaryenModuleRef module,
                   const char* target,
                   BinaryenExpressionRef* operands,
                   BinaryenIndex numOperands,
                   BinaryenType returnType);
 BinaryenExpressionRef
BinaryenReturnCallIndirect(BinaryenModuleRef module,
                           BinaryenExpressionRef target,
                           BinaryenExpressionRef* operands,
                           BinaryenIndex numOperands,
                           const char* type);
 BinaryenExpressionRef BinaryenLocalGet(BinaryenModuleRef module,
                                                    BinaryenIndex index,
                                                    BinaryenType type);
 BinaryenExpressionRef BinaryenLocalSet(
  BinaryenModuleRef module, BinaryenIndex index, BinaryenExpressionRef value);
 BinaryenExpressionRef BinaryenLocalTee(
  BinaryenModuleRef module, BinaryenIndex index, BinaryenExpressionRef value);
 BinaryenExpressionRef BinaryenGlobalGet(BinaryenModuleRef module,
                                                     const char* name,
                                                     BinaryenType type);
 BinaryenExpressionRef BinaryenGlobalSet(
  BinaryenModuleRef module, const char* name, BinaryenExpressionRef value);
 BinaryenExpressionRef BinaryenLoad(BinaryenModuleRef module,
                                                uint32_t bytes,
                                                int8_t signed_,
                                                uint32_t offset,
                                                uint32_t align,
                                                BinaryenType type,
                                                BinaryenExpressionRef ptr);
 BinaryenExpressionRef BinaryenStore(BinaryenModuleRef module,
                                                 uint32_t bytes,
                                                 uint32_t offset,
                                                 uint32_t align,
                                                 BinaryenExpressionRef ptr,
                                                 BinaryenExpressionRef value,
                                                 BinaryenType type);
 BinaryenExpressionRef BinaryenConst(BinaryenModuleRef module,
                                                 struct BinaryenLiteral value);
 BinaryenExpressionRef BinaryenUnary(BinaryenModuleRef module,
                                                 BinaryenOp op,
                                                 BinaryenExpressionRef value);
 BinaryenExpressionRef BinaryenBinary(BinaryenModuleRef module,
                                                  BinaryenOp op,
                                                  BinaryenExpressionRef left,
                                                  BinaryenExpressionRef right);
 BinaryenExpressionRef
BinaryenSelect(BinaryenModuleRef module,
               BinaryenExpressionRef condition,
               BinaryenExpressionRef ifTrue,
               BinaryenExpressionRef ifFalse);
 BinaryenExpressionRef BinaryenDrop(BinaryenModuleRef module,
                                                BinaryenExpressionRef value);
 BinaryenExpressionRef BinaryenReturn(BinaryenModuleRef module,
                                                  BinaryenExpressionRef value);
 BinaryenExpressionRef BinaryenHost(BinaryenModuleRef module,
                                                BinaryenOp op,
                                                const char* name,
                                                BinaryenExpressionRef* operands,
                                                BinaryenIndex numOperands);
 BinaryenExpressionRef BinaryenNop(BinaryenModuleRef module);
 BinaryenExpressionRef
BinaryenUnreachable(BinaryenModuleRef module);
 BinaryenExpressionRef
BinaryenAtomicLoad(BinaryenModuleRef module,
                   uint32_t bytes,
                   uint32_t offset,
                   BinaryenType type,
                   BinaryenExpressionRef ptr);
 BinaryenExpressionRef
BinaryenAtomicStore(BinaryenModuleRef module,
                    uint32_t bytes,
                    uint32_t offset,
                    BinaryenExpressionRef ptr,
                    BinaryenExpressionRef value,
                    BinaryenType type);
 BinaryenExpressionRef
BinaryenAtomicRMW(BinaryenModuleRef module,
                  BinaryenOp op,
                  BinaryenIndex bytes,
                  BinaryenIndex offset,
                  BinaryenExpressionRef ptr,
                  BinaryenExpressionRef value,
                  BinaryenType type);
 BinaryenExpressionRef
BinaryenAtomicCmpxchg(BinaryenModuleRef module,
                      BinaryenIndex bytes,
                      BinaryenIndex offset,
                      BinaryenExpressionRef ptr,
                      BinaryenExpressionRef expected,
                      BinaryenExpressionRef replacement,
                      BinaryenType type);
 BinaryenExpressionRef
BinaryenAtomicWait(BinaryenModuleRef module,
                   BinaryenExpressionRef ptr,
                   BinaryenExpressionRef expected,
                   BinaryenExpressionRef timeout,
                   BinaryenType type);
 BinaryenExpressionRef
BinaryenAtomicNotify(BinaryenModuleRef module,
                     BinaryenExpressionRef ptr,
                     BinaryenExpressionRef notifyCount);
 BinaryenExpressionRef
BinaryenAtomicFence(BinaryenModuleRef module);
 BinaryenExpressionRef
BinaryenSIMDExtract(BinaryenModuleRef module,
                    BinaryenOp op,
                    BinaryenExpressionRef vec,
                    uint8_t index);
 BinaryenExpressionRef
BinaryenSIMDReplace(BinaryenModuleRef module,
                    BinaryenOp op,
                    BinaryenExpressionRef vec,
                    uint8_t index,
                    BinaryenExpressionRef value);
 BinaryenExpressionRef
BinaryenSIMDShuffle(BinaryenModuleRef module,
                    BinaryenExpressionRef left,
                    BinaryenExpressionRef right,
                    const uint8_t mask[16]);
 BinaryenExpressionRef BinaryenSIMDTernary(BinaryenModuleRef module,
                                                       BinaryenOp op,
                                                       BinaryenExpressionRef a,
                                                       BinaryenExpressionRef b,
                                                       BinaryenExpressionRef c);
 BinaryenExpressionRef
BinaryenSIMDShift(BinaryenModuleRef module,
                  BinaryenOp op,
                  BinaryenExpressionRef vec,
                  BinaryenExpressionRef shift);
 BinaryenExpressionRef BinaryenSIMDLoad(BinaryenModuleRef module,
                                                    BinaryenOp op,
                                                    uint32_t offset,
                                                    uint32_t align,
                                                    BinaryenExpressionRef ptr);
 BinaryenExpressionRef
BinaryenMemoryInit(BinaryenModuleRef module,
                   uint32_t segment,
                   BinaryenExpressionRef dest,
                   BinaryenExpressionRef offset,
                   BinaryenExpressionRef size);
 BinaryenExpressionRef BinaryenDataDrop(BinaryenModuleRef module,
                                                    uint32_t segment);
 BinaryenExpressionRef
BinaryenMemoryCopy(BinaryenModuleRef module,
                   BinaryenExpressionRef dest,
                   BinaryenExpressionRef source,
                   BinaryenExpressionRef size);
 BinaryenExpressionRef
BinaryenMemoryFill(BinaryenModuleRef module,
                   BinaryenExpressionRef dest,
                   BinaryenExpressionRef value,
                   BinaryenExpressionRef size);
 BinaryenExpressionRef BinaryenTry(BinaryenModuleRef module,
                                               BinaryenExpressionRef body,
                                               BinaryenExpressionRef catchBody);
 BinaryenExpressionRef
BinaryenThrow(BinaryenModuleRef module,
              const char* event,
              BinaryenExpressionRef* operands,
              BinaryenIndex numOperands);
 BinaryenExpressionRef
BinaryenRethrow(BinaryenModuleRef module, BinaryenExpressionRef exnref);
 BinaryenExpressionRef
BinaryenBrOnExn(BinaryenModuleRef module,
                const char* name,
                const char* eventName,
                BinaryenExpressionRef exnref);
 BinaryenExpressionRef BinaryenPush(BinaryenModuleRef module,
                                                BinaryenExpressionRef value);
 BinaryenExpressionRef BinaryenPop(BinaryenModuleRef module,
                                               BinaryenType type);
 BinaryenExpressionId
BinaryenExpressionGetId(BinaryenExpressionRef expr);
 BinaryenType BinaryenExpressionGetType(BinaryenExpressionRef expr);
 void BinaryenExpressionPrint(BinaryenExpressionRef expr);
 const char* BinaryenBlockGetName(BinaryenExpressionRef expr);
 BinaryenIndex
BinaryenBlockGetNumChildren(BinaryenExpressionRef expr);
 BinaryenExpressionRef
BinaryenBlockGetChild(BinaryenExpressionRef expr, BinaryenIndex index);
 BinaryenExpressionRef
BinaryenIfGetCondition(BinaryenExpressionRef expr);
 BinaryenExpressionRef
BinaryenIfGetIfTrue(BinaryenExpressionRef expr);
 BinaryenExpressionRef
BinaryenIfGetIfFalse(BinaryenExpressionRef expr);
 const char* BinaryenLoopGetName(BinaryenExpressionRef expr);
 BinaryenExpressionRef
BinaryenLoopGetBody(BinaryenExpressionRef expr);
 const char* BinaryenBreakGetName(BinaryenExpressionRef expr);
 BinaryenExpressionRef
BinaryenBreakGetCondition(BinaryenExpressionRef expr);
 BinaryenExpressionRef
BinaryenBreakGetValue(BinaryenExpressionRef expr);
 BinaryenIndex
BinaryenSwitchGetNumNames(BinaryenExpressionRef expr);
 const char* BinaryenSwitchGetName(BinaryenExpressionRef expr,
                                               BinaryenIndex index);
 const char*
BinaryenSwitchGetDefaultName(BinaryenExpressionRef expr);
 BinaryenExpressionRef
BinaryenSwitchGetCondition(BinaryenExpressionRef expr);
 BinaryenExpressionRef
BinaryenSwitchGetValue(BinaryenExpressionRef expr);
 const char* BinaryenCallGetTarget(BinaryenExpressionRef expr);
 BinaryenIndex
BinaryenCallGetNumOperands(BinaryenExpressionRef expr);
 BinaryenExpressionRef
BinaryenCallGetOperand(BinaryenExpressionRef expr, BinaryenIndex index);
 BinaryenExpressionRef
BinaryenCallIndirectGetTarget(BinaryenExpressionRef expr);
 BinaryenIndex
BinaryenCallIndirectGetNumOperands(BinaryenExpressionRef expr);
 BinaryenExpressionRef
BinaryenCallIndirectGetOperand(BinaryenExpressionRef expr, BinaryenIndex index);
 BinaryenIndex BinaryenLocalGetGetIndex(BinaryenExpressionRef expr);
 int BinaryenLocalSetIsTee(BinaryenExpressionRef expr);
 BinaryenIndex BinaryenLocalSetGetIndex(BinaryenExpressionRef expr);
 BinaryenExpressionRef
BinaryenLocalSetGetValue(BinaryenExpressionRef expr);
 const char* BinaryenGlobalGetGetName(BinaryenExpressionRef expr);
 const char* BinaryenGlobalSetGetName(BinaryenExpressionRef expr);
 BinaryenExpressionRef
BinaryenGlobalSetGetValue(BinaryenExpressionRef expr);
 BinaryenOp BinaryenHostGetOp(BinaryenExpressionRef expr);
 const char* BinaryenHostGetNameOperand(BinaryenExpressionRef expr);
 BinaryenIndex
BinaryenHostGetNumOperands(BinaryenExpressionRef expr);
 BinaryenExpressionRef
BinaryenHostGetOperand(BinaryenExpressionRef expr, BinaryenIndex index);
 int BinaryenLoadIsAtomic(BinaryenExpressionRef expr);
 int BinaryenLoadIsSigned(BinaryenExpressionRef expr);
 uint32_t BinaryenLoadGetOffset(BinaryenExpressionRef expr);
 uint32_t BinaryenLoadGetBytes(BinaryenExpressionRef expr);
 uint32_t BinaryenLoadGetAlign(BinaryenExpressionRef expr);
 BinaryenExpressionRef
BinaryenLoadGetPtr(BinaryenExpressionRef expr);
 int BinaryenStoreIsAtomic(BinaryenExpressionRef expr);
 uint32_t BinaryenStoreGetBytes(BinaryenExpressionRef expr);
 uint32_t BinaryenStoreGetOffset(BinaryenExpressionRef expr);
 uint32_t BinaryenStoreGetAlign(BinaryenExpressionRef expr);
 BinaryenExpressionRef
BinaryenStoreGetPtr(BinaryenExpressionRef expr);
 BinaryenExpressionRef
BinaryenStoreGetValue(BinaryenExpressionRef expr);
 int32_t BinaryenConstGetValueI32(BinaryenExpressionRef expr);
 int64_t BinaryenConstGetValueI64(BinaryenExpressionRef expr);
 int32_t BinaryenConstGetValueI64Low(BinaryenExpressionRef expr);
 int32_t BinaryenConstGetValueI64High(BinaryenExpressionRef expr);
 float BinaryenConstGetValueF32(BinaryenExpressionRef expr);
 double BinaryenConstGetValueF64(BinaryenExpressionRef expr);
 void BinaryenConstGetValueV128(BinaryenExpressionRef expr,
                                            uint8_t* out);
 BinaryenOp BinaryenUnaryGetOp(BinaryenExpressionRef expr);
 BinaryenExpressionRef
BinaryenUnaryGetValue(BinaryenExpressionRef expr);
 BinaryenOp BinaryenBinaryGetOp(BinaryenExpressionRef expr);
 BinaryenExpressionRef
BinaryenBinaryGetLeft(BinaryenExpressionRef expr);
 BinaryenExpressionRef
BinaryenBinaryGetRight(BinaryenExpressionRef expr);
 BinaryenExpressionRef
BinaryenSelectGetIfTrue(BinaryenExpressionRef expr);
 BinaryenExpressionRef
BinaryenSelectGetIfFalse(BinaryenExpressionRef expr);
 BinaryenExpressionRef
BinaryenSelectGetCondition(BinaryenExpressionRef expr);
 BinaryenExpressionRef
BinaryenDropGetValue(BinaryenExpressionRef expr);
 BinaryenExpressionRef
BinaryenReturnGetValue(BinaryenExpressionRef expr);
 BinaryenOp BinaryenAtomicRMWGetOp(BinaryenExpressionRef expr);
 uint32_t BinaryenAtomicRMWGetBytes(BinaryenExpressionRef expr);
 uint32_t BinaryenAtomicRMWGetOffset(BinaryenExpressionRef expr);
 BinaryenExpressionRef
BinaryenAtomicRMWGetPtr(BinaryenExpressionRef expr);
 BinaryenExpressionRef
BinaryenAtomicRMWGetValue(BinaryenExpressionRef expr);
 uint32_t BinaryenAtomicCmpxchgGetBytes(BinaryenExpressionRef expr);
 uint32_t
BinaryenAtomicCmpxchgGetOffset(BinaryenExpressionRef expr);
 BinaryenExpressionRef
BinaryenAtomicCmpxchgGetPtr(BinaryenExpressionRef expr);
 BinaryenExpressionRef
BinaryenAtomicCmpxchgGetExpected(BinaryenExpressionRef expr);
 BinaryenExpressionRef
BinaryenAtomicCmpxchgGetReplacement(BinaryenExpressionRef expr);
 BinaryenExpressionRef
BinaryenAtomicWaitGetPtr(BinaryenExpressionRef expr);
 BinaryenExpressionRef
BinaryenAtomicWaitGetExpected(BinaryenExpressionRef expr);
 BinaryenExpressionRef
BinaryenAtomicWaitGetTimeout(BinaryenExpressionRef expr);
 BinaryenType
BinaryenAtomicWaitGetExpectedType(BinaryenExpressionRef expr);
 BinaryenExpressionRef
BinaryenAtomicNotifyGetPtr(BinaryenExpressionRef expr);
 BinaryenExpressionRef
BinaryenAtomicNotifyGetNotifyCount(BinaryenExpressionRef expr);
 uint8_t BinaryenAtomicFenceGetOrder(BinaryenExpressionRef expr);
 BinaryenOp BinaryenSIMDExtractGetOp(BinaryenExpressionRef expr);
 BinaryenExpressionRef
BinaryenSIMDExtractGetVec(BinaryenExpressionRef expr);
 uint8_t BinaryenSIMDExtractGetIndex(BinaryenExpressionRef expr);
 BinaryenOp BinaryenSIMDReplaceGetOp(BinaryenExpressionRef expr);
 BinaryenExpressionRef
BinaryenSIMDReplaceGetVec(BinaryenExpressionRef expr);
 uint8_t BinaryenSIMDReplaceGetIndex(BinaryenExpressionRef expr);
 BinaryenExpressionRef
BinaryenSIMDReplaceGetValue(BinaryenExpressionRef expr);
 BinaryenExpressionRef
BinaryenSIMDShuffleGetLeft(BinaryenExpressionRef expr);
 BinaryenExpressionRef
BinaryenSIMDShuffleGetRight(BinaryenExpressionRef expr);
 void BinaryenSIMDShuffleGetMask(BinaryenExpressionRef expr,
                                             uint8_t* mask);
 BinaryenOp BinaryenSIMDTernaryGetOp(BinaryenExpressionRef expr);
 BinaryenExpressionRef
BinaryenSIMDTernaryGetA(BinaryenExpressionRef expr);
 BinaryenExpressionRef
BinaryenSIMDTernaryGetB(BinaryenExpressionRef expr);
 BinaryenExpressionRef
BinaryenSIMDTernaryGetC(BinaryenExpressionRef expr);
 BinaryenOp BinaryenSIMDShiftGetOp(BinaryenExpressionRef expr);
 BinaryenExpressionRef
BinaryenSIMDShiftGetVec(BinaryenExpressionRef expr);
 BinaryenExpressionRef
BinaryenSIMDShiftGetShift(BinaryenExpressionRef expr);
 BinaryenOp BinaryenSIMDLoadGetOp(BinaryenExpressionRef expr);
 uint32_t BinaryenSIMDLoadGetOffset(BinaryenExpressionRef expr);
 uint32_t BinaryenSIMDLoadGetAlign(BinaryenExpressionRef expr);
 BinaryenExpressionRef
BinaryenSIMDLoadGetPtr(BinaryenExpressionRef expr);
 uint32_t BinaryenMemoryInitGetSegment(BinaryenExpressionRef expr);
 BinaryenExpressionRef
BinaryenMemoryInitGetDest(BinaryenExpressionRef expr);
 BinaryenExpressionRef
BinaryenMemoryInitGetOffset(BinaryenExpressionRef expr);
 BinaryenExpressionRef
BinaryenMemoryInitGetSize(BinaryenExpressionRef expr);
 uint32_t BinaryenDataDropGetSegment(BinaryenExpressionRef expr);
 BinaryenExpressionRef
BinaryenMemoryCopyGetDest(BinaryenExpressionRef expr);
 BinaryenExpressionRef
BinaryenMemoryCopyGetSource(BinaryenExpressionRef expr);
 BinaryenExpressionRef
BinaryenMemoryCopyGetSize(BinaryenExpressionRef expr);
 BinaryenExpressionRef
BinaryenMemoryFillGetDest(BinaryenExpressionRef expr);
 BinaryenExpressionRef
BinaryenMemoryFillGetValue(BinaryenExpressionRef expr);
 BinaryenExpressionRef
BinaryenMemoryFillGetSize(BinaryenExpressionRef expr);
 BinaryenExpressionRef
BinaryenTryGetBody(BinaryenExpressionRef expr);
 BinaryenExpressionRef
BinaryenTryGetCatchBody(BinaryenExpressionRef expr);
 const char* BinaryenThrowGetEvent(BinaryenExpressionRef expr);
 BinaryenExpressionRef
BinaryenThrowGetOperand(BinaryenExpressionRef expr, BinaryenIndex index);
 BinaryenIndex
BinaryenThrowGetNumOperands(BinaryenExpressionRef expr);
 BinaryenExpressionRef
BinaryenRethrowGetExnref(BinaryenExpressionRef expr);
 const char* BinaryenBrOnExnGetEvent(BinaryenExpressionRef expr);
 const char* BinaryenBrOnExnGetName(BinaryenExpressionRef expr);
 BinaryenExpressionRef
BinaryenBrOnExnGetExnref(BinaryenExpressionRef expr);
 BinaryenExpressionRef
BinaryenPushGetValue(BinaryenExpressionRef expr);
typedef void* BinaryenFunctionRef;
 BinaryenFunctionRef
BinaryenAddFunction(BinaryenModuleRef module,
                    const char* name,
                    BinaryenFunctionTypeRef type,
                    BinaryenType* varTypes,
                    BinaryenIndex numVarTypes,
                    BinaryenExpressionRef body);
 BinaryenFunctionRef BinaryenGetFunction(BinaryenModuleRef module,
                                                     const char* name);
 void BinaryenRemoveFunction(BinaryenModuleRef module,
                                         const char* name);
 void
BinaryenAddFunctionImport(BinaryenModuleRef module,
                          const char* internalName,
                          const char* externalModuleName,
                          const char* externalBaseName,
                          BinaryenFunctionTypeRef functionType);
 void BinaryenAddTableImport(BinaryenModuleRef module,
                                         const char* internalName,
                                         const char* externalModuleName,
                                         const char* externalBaseName);
 void BinaryenAddMemoryImport(BinaryenModuleRef module,
                                          const char* internalName,
                                          const char* externalModuleName,
                                          const char* externalBaseName,
                                          uint8_t shared);
 void BinaryenAddGlobalImport(BinaryenModuleRef module,
                                          const char* internalName,
                                          const char* externalModuleName,
                                          const char* externalBaseName,
                                          BinaryenType globalType,
                                          int mutable_);
 void BinaryenAddEventImport(BinaryenModuleRef module,
                                         const char* internalName,
                                         const char* externalModuleName,
                                         const char* externalBaseName,
                                         uint32_t attribute,
                                         BinaryenFunctionTypeRef eventType);
typedef void* BinaryenExportRef;
 BinaryenExportRef BinaryenAddFunctionExport(
  BinaryenModuleRef module, const char* internalName, const char* externalName);
 BinaryenExportRef BinaryenAddTableExport(BinaryenModuleRef module,
                                                      const char* internalName,
                                                      const char* externalName);
 BinaryenExportRef BinaryenAddMemoryExport(
  BinaryenModuleRef module, const char* internalName, const char* externalName);
 BinaryenExportRef BinaryenAddGlobalExport(
  BinaryenModuleRef module, const char* internalName, const char* externalName);
 BinaryenExportRef BinaryenAddEventExport(BinaryenModuleRef module,
                                                      const char* internalName,
                                                      const char* externalName);
 void BinaryenRemoveExport(BinaryenModuleRef module,
                                       const char* externalName);
typedef void* BinaryenGlobalRef;
 BinaryenGlobalRef BinaryenAddGlobal(BinaryenModuleRef module,
                                                 const char* name,
                                                 BinaryenType type,
                                                 int8_t mutable_,
                                                 BinaryenExpressionRef init);
 BinaryenGlobalRef BinaryenGetGlobal(BinaryenModuleRef module,
                                                 const char* name);
 void BinaryenRemoveGlobal(BinaryenModuleRef module,
                                       const char* name);
typedef void* BinaryenEventRef;
 BinaryenEventRef BinaryenAddEvent(BinaryenModuleRef module,
                                               const char* name,
                                               uint32_t attribute,
                                               BinaryenFunctionTypeRef type);
 BinaryenEventRef BinaryenGetEvent(BinaryenModuleRef module,
                                               const char* name);
 void BinaryenRemoveEvent(BinaryenModuleRef module,
                                      const char* name);
 void BinaryenSetFunctionTable(BinaryenModuleRef module,
                                           BinaryenIndex initial,
                                           BinaryenIndex maximum,
                                           const char** funcNames,
                                           BinaryenIndex numFuncNames,
                                           BinaryenExpressionRef offset);
 void BinaryenSetMemory(BinaryenModuleRef module,
                                    BinaryenIndex initial,
                                    BinaryenIndex maximum,
                                    const char* exportName,
                                    const char** segments,
                                    int8_t* segmentPassive,
                                    BinaryenExpressionRef* segmentOffsets,
                                    BinaryenIndex* segmentSizes,
                                    BinaryenIndex numSegments,
                                    uint8_t shared);
 void BinaryenSetStart(BinaryenModuleRef module,
                                   BinaryenFunctionRef start);
 BinaryenFeatures
BinaryenModuleGetFeatures(BinaryenModuleRef module);
 void BinaryenModuleSetFeatures(BinaryenModuleRef module,
                                            BinaryenFeatures features);
 BinaryenModuleRef BinaryenModuleParse(const char* text);
 void BinaryenModulePrint(BinaryenModuleRef module);
 void BinaryenModulePrintAsmjs(BinaryenModuleRef module);
 int BinaryenModuleValidate(BinaryenModuleRef module);
 void BinaryenModuleOptimize(BinaryenModuleRef module);
 int BinaryenGetOptimizeLevel(void);
 void BinaryenSetOptimizeLevel(int level);
 int BinaryenGetShrinkLevel(void);
 void BinaryenSetShrinkLevel(int level);
 int BinaryenGetDebugInfo(void);
 void BinaryenSetDebugInfo(int on);
 void BinaryenModuleRunPasses(BinaryenModuleRef module,
                                          const char** passes,
                                          BinaryenIndex numPasses);
 void BinaryenModuleAutoDrop(BinaryenModuleRef module);
size_t BinaryenModuleWrite(BinaryenModuleRef module,
                                        char* output,
                                        size_t outputSize);
 size_t BinaryenModuleWriteText(BinaryenModuleRef module,
                                            char* output,
                                            size_t outputSize);
typedef struct BinaryenBufferSizes {
  size_t outputBytes;
  size_t sourceMapBytes;
} BinaryenBufferSizes;
 BinaryenBufferSizes
BinaryenModuleWriteWithSourceMap(BinaryenModuleRef module,
                                 const char* url,
                                 char* output,
                                 size_t outputSize,
                                 char* sourceMap,
                                 size_t sourceMapSize);
typedef struct BinaryenModuleAllocateAndWriteResult {
  void* binary;
  size_t binaryBytes;
  char* sourceMap;
} BinaryenModuleAllocateAndWriteResult;
 BinaryenModuleAllocateAndWriteResult
BinaryenModuleAllocateAndWrite(BinaryenModuleRef module,
                               const char* sourceMapUrl);
 char*
BinaryenModuleAllocateAndWriteText(BinaryenModuleRef* module);
 BinaryenModuleRef BinaryenModuleRead(char* input,
                                                  size_t inputSize);
 void BinaryenModuleInterpret(BinaryenModuleRef module);
 BinaryenIndex BinaryenModuleAddDebugInfoFileName(
  BinaryenModuleRef module, const char* filename);
 const char*
BinaryenModuleGetDebugInfoFileName(BinaryenModuleRef module,
                                   BinaryenIndex index);
 const char*
BinaryenFunctionTypeGetName(BinaryenFunctionTypeRef ftype);
 BinaryenIndex
BinaryenFunctionTypeGetNumParams(BinaryenFunctionTypeRef ftype);
 BinaryenType BinaryenFunctionTypeGetParam(
  BinaryenFunctionTypeRef ftype, BinaryenIndex index);
 BinaryenType
BinaryenFunctionTypeGetResult(BinaryenFunctionTypeRef ftype);
 const char* BinaryenFunctionGetName(BinaryenFunctionRef func);
 const char* BinaryenFunctionGetType(BinaryenFunctionRef func);
 BinaryenIndex
BinaryenFunctionGetNumParams(BinaryenFunctionRef func);
 BinaryenType BinaryenFunctionGetParam(BinaryenFunctionRef func,
                                                   BinaryenIndex index);
 BinaryenType BinaryenFunctionGetResult(BinaryenFunctionRef func);
 BinaryenIndex BinaryenFunctionGetNumVars(BinaryenFunctionRef func);
 BinaryenType BinaryenFunctionGetVar(BinaryenFunctionRef func,
                                                 BinaryenIndex index);
 BinaryenExpressionRef
BinaryenFunctionGetBody(BinaryenFunctionRef func);
 void BinaryenFunctionOptimize(BinaryenFunctionRef func,
                                           BinaryenModuleRef module);
 void BinaryenFunctionRunPasses(BinaryenFunctionRef func,
                                            BinaryenModuleRef module,
                                            const char** passes,
                                            BinaryenIndex numPasses);
 void BinaryenFunctionSetDebugLocation(BinaryenFunctionRef func,
                                                   BinaryenExpressionRef expr,
                                                   BinaryenIndex fileIndex,
                                                   BinaryenIndex lineNumber,
                                                   BinaryenIndex columnNumber);
 const char* BinaryenGlobalGetName(BinaryenGlobalRef global);
 BinaryenType BinaryenGlobalGetType(BinaryenGlobalRef global);
 int BinaryenGlobalIsMutable(BinaryenGlobalRef global);
 BinaryenExpressionRef
BinaryenGlobalGetInitExpr(BinaryenGlobalRef global);
 const char* BinaryenEventGetName(BinaryenEventRef event);
 int BinaryenEventGetAttribute(BinaryenEventRef event);
 const char* BinaryenEventGetType(BinaryenEventRef event);
 BinaryenIndex BinaryenEventGetNumParams(BinaryenEventRef event);
 BinaryenType BinaryenEventGetParam(BinaryenEventRef event,
                                                BinaryenIndex index);
 const char*
BinaryenFunctionImportGetModule(BinaryenFunctionRef import);
 const char*
BinaryenGlobalImportGetModule(BinaryenGlobalRef import);
 const char* BinaryenEventImportGetModule(BinaryenEventRef import);
 const char*
BinaryenFunctionImportGetBase(BinaryenFunctionRef import);
 const char* BinaryenGlobalImportGetBase(BinaryenGlobalRef import);
 const char* BinaryenEventImportGetBase(BinaryenEventRef import);
 BinaryenExternalKind
BinaryenExportGetKind(BinaryenExportRef export_);
 const char* BinaryenExportGetName(BinaryenExportRef export_);
 const char* BinaryenExportGetValue(BinaryenExportRef export_);
 void BinaryenAddCustomSection(BinaryenModuleRef module,
                                           const char* name,
                                           const char* contents,
                                           BinaryenIndex contentsSize);
typedef void* RelooperRef;
typedef void* RelooperBlockRef;
 RelooperRef RelooperCreate(BinaryenModuleRef module);
 RelooperBlockRef RelooperAddBlock(RelooperRef relooper,
                                               BinaryenExpressionRef code);
 void RelooperAddBranch(RelooperBlockRef from,
                                    RelooperBlockRef to,
                                    BinaryenExpressionRef condition,
                                    BinaryenExpressionRef code);
 RelooperBlockRef
RelooperAddBlockWithSwitch(RelooperRef relooper,
                           BinaryenExpressionRef code,
                           BinaryenExpressionRef condition);
 void RelooperAddBranchForSwitch(RelooperBlockRef from,
                                             RelooperBlockRef to,
                                             BinaryenIndex* indexes,
                                             BinaryenIndex numIndexes,
                                             BinaryenExpressionRef code);
 BinaryenExpressionRef RelooperRenderAndDispose(
  RelooperRef relooper, RelooperBlockRef entry, BinaryenIndex labelHelper);
 void BinaryenSetAPITracing(int on);
 BinaryenFunctionTypeRef
BinaryenGetFunctionTypeBySignature(BinaryenModuleRef module,
                                   BinaryenType result,
                                   BinaryenType* paramTypes,
                                   BinaryenIndex numParams);
 void BinaryenSetColorsEnabled(int enabled);
 int BinaryenAreColorsEnabled();
