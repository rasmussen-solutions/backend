databaseChangeLog {
  changeSet(id: '''1599035447580-1''', author: '''emil (generated)''') {
    createTable(tableName: '''companies''') {
      column(name: '''id''', type: '''BIGINT''', autoIncrement: true) {
        constraints(primaryKey: true, primaryKeyName: '''companiesPK''')
      }
      column(name: '''company_name''', type: '''VARCHAR(255)''')
      column(name: '''email''', type: '''VARCHAR(255)''')
      column(name: '''phone_number''', type: '''VARCHAR(255)''')
    }
  }

}
