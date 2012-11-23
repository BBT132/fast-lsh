/*
   Copyright 2012 Michael Mastroianni, Amol Kapile (fastlsh.org)
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
   limitations under the License.
 */

package org.fastlsh.hash;


import org.fastlsh.util.BitSet;

import cern.colt.matrix.DoubleMatrix1D;

public class HashFamily
{
    HashFunction [] hashes;
    public HashFamily(HashFunction [] hs)
    {
        hashes = hs;
    }
    
    public BitSet makeSignature(DoubleMatrix1D input)
    {
        BitSet retval = new BitSet(hashes.length);
        for(int i = 0, max = hashes.length; i < max; i++)
        {
            retval.set(i, hashes[i].hash(input));
        }
        return retval;
    }
}