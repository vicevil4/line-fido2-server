/*
 * Copyright 2021 LINE Corporation
 *
 * LINE Corporation licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.linecorp.line.auth.fido.fido2.server.attestation.tpm;

import java.util.Arrays;

import com.linecorp.line.auth.fido.fido2.server.error.InternalErrorCode;
import com.linecorp.line.auth.fido.fido2.server.exception.FIDO2ServerRuntimeException;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum TpmKeyAlgorithm {
    RSA(0x0001),
    ECC(0x0023);

    @Getter private final int value;

    public static TpmKeyAlgorithm fromValue(int value) {
        return Arrays.stream(TpmKeyAlgorithm.values())
                .filter(e -> e.value == value)
                .findFirst()
                .orElseThrow(() -> new FIDO2ServerRuntimeException(InternalErrorCode.TPM_ATTESTATION_DATA_INVALID));

    }
}
