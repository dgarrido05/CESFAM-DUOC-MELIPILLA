using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

using System.Security.Cryptography;

namespace Servicio
{
    internal class Helper
    {
        public static string EncodeClave(string originalClave)
        {            
            SHA512 sha512 = new SHA512CryptoServiceProvider(); 
            byte[] arrHash = sha512.ComputeHash(Encoding.UTF8.GetBytes(originalClave));
            StringBuilder sbHash = new StringBuilder();
            for (int i = 0; i < arrHash.Length; i++)
            {
                sbHash.Append(arrHash[i].ToString("x2"));
            }
            return sbHash.ToString();
        }
    }
}
