using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

using System.Data;
using Oracle.DataAccess.Client;
using System.Configuration;

namespace Servicio
{
    public static class Login
    {
        public static bool Autenticar(string usuario, string clave)
        {
            string query = @"SELECT COUNT(*) FROM ces_usuario 
                                           WHERE usu_nombre_usuario = :usuario 
                                           AND usu_clave = :clave
                                           AND tipo_usuario_id = 2"; //ID de medicos

            using (OracleConnection _connection = new OracleConnection(ConfigurationManager.ConnectionStrings["CESFAM.XE"].ToString()))
            {
                _connection.Open();

                OracleCommand command = new OracleCommand(query, _connection);
                
                command.Parameters.Add(":usuario", usuario);                           
                string hash = Helper.EncodeClave(clave);
                command.Parameters.Add(":clave", hash);                
                ////command.Parameters.AddWithValue(":clave", clave);

                int count = Convert.ToInt32(command.ExecuteScalar());
                if (count == 1)
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
        }

        public static DataTable ConsultaUsuario(string usuario, string clave)
        {
            string query = @"SELECT * FROM ces_usuario 
                                         WHERE usu_nombre_usuario = :usu_nombre_usuario 
                                         AND usu_clave = :clave
                                         AND tipo_usuario_id = 2"; //ID de medicos

            using (OracleConnection _connection = new OracleConnection(ConfigurationManager.ConnectionStrings["CESFAM.XE"].ToString()))
            {
                OracleCommand command = new OracleCommand(query, _connection);
                
                command.Parameters.Add(":usu_nombre_usuario", usuario);                
                string hash = Helper.EncodeClave(clave);
                command.Parameters.Add(":clave", hash);                
                ////command.Parameters.AddWithValue(":clave", clave);

                _connection.Open();
                OracleDataAdapter Adaptador = new OracleDataAdapter(command);
                DataTable dtDatos = new DataTable();
                Adaptador.Fill(dtDatos);
                return dtDatos;
            }
        }
    }
}
