databaseChangeLog {
  changeSet(id: '''1596385260101-1''', author: '''emilrasmussen (generated)''') {
    createTable(tableName: '''companies''') {
      column(name: '''id''', type: '''BIGINT''', autoIncrement: true) {
        constraints(primaryKey: true, primaryKeyName: '''companies_pk''')
      }
      column(name: '''company_name''', type: '''VARCHAR(255)''')
      column(name: '''email''', type: '''VARCHAR(255)''')
      column(name: '''phone_number''', type: '''VARCHAR(255)''')
    }
  }

  changeSet(id: '''1596385260101-2''', author: '''emilrasmussen (generated)''') {
    dropSequence(sequenceName: '''companies_id_seq''')
  }

}
