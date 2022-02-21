package databaseClass.table;

import databaseClass.ConnDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


// DAO == Data Access Object
// VO == Value Object

public class TableModelDAO extends ConnDB {

    // clicked table button without constraints
    public ArrayList<TableModelVO> initialTableList() {


        String query = "SELECT " +
                "trade_id, apart_group, address_road, address_detailed, trade_price_10000won, " +
                "`area_m^2`, construction_year, floor, contract_year_month, contract_date " +
                "FROM apartment_price ORDER BY contract_year_month + contract_date " +
                "DESC LIMIT 5000";

        return getTableList(query);
    }

    // overloading
    public ArrayList<TableModelVO> initialTableList(ConstraintModelVO constraintModelVO) {

        String keyword = constraintModelVO.getConstraintKeyword();


        String query = "SELECT " +
                "trade_id, apart_group, address_road, address_detailed, trade_price_10000won, " +
                "`area_m^2`, construction_year, floor, contract_year_month, contract_date " +
                "FROM apartment_price ";

        if (!keyword.isEmpty()) {
            // %% mean % literal in String.format
            String keywordQuery = String.format("""
                    WHERE address_detailed LIKE '%%%s%%'
                    OR apart_group LIKE '%%%s%%'
                    OR trade_price_10000won LIKE '%%%s%%'
                    OR construction_year LIKE '%%%s%%'
                    OR address_road LIKE '%%%s%%'
                    OR expire_date LIKE '%%%s%%'
                    OR floor LIKE '%s'
                    OR agency_region LIKE '%%%s%%'""", keyword, keyword, keyword, keyword, keyword, keyword, keyword, keyword);
            query += keywordQuery;
        }

        String queryOrderBy = "ORDER BY contract_year_month + contract_date DESC ";
        String queryLimit = "LIMIT 5000";

        query += queryOrderBy;
        query += queryLimit;

        return getTableList(query);
    }


    private ArrayList<TableModelVO> getTableList(String query) {

        ArrayList<TableModelVO> list = new ArrayList<>();
        ResultSet resultSet = null;
        PreparedStatement getTableStmt = null;

        try {
            connDB();

            getTableStmt = conn.prepareStatement(query);

            resultSet = getTableStmt.executeQuery();

            while (resultSet.next()) {
                Integer tradeID = resultSet.getInt("trade_id");
                String apartGroup = resultSet.getString("apart_group");
                String addressRoad = resultSet.getString("address_road");
                String addressDetailed = resultSet.getString("address_detailed");
                String price = resultSet.getString("trade_price_10000won");
                String area = resultSet.getString("area_m^2");
                String constructionYear = resultSet.getString("construction_year");
                String floor = resultSet.getString("floor");
                String contractDate = resultSet.getString("contract_year_month") + resultSet.getString(
                        "contract_date");
                TableModelVO data = new TableModelVO(tradeID, apartGroup, addressRoad, addressDetailed, price, area,
                        constructionYear, floor, contractDate);

                list.add(data);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }


        return list;
    }
}